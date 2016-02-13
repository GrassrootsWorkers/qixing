package com.dream.qixing.mobile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.dream.qixing.mobile.constants.Constants;
import com.dream.qixing.mobile.util.PureStringHashMap;
import com.dream.qixing.mobile.util.RequestParametersHolder;
import com.dream.qixing.mobile.util.TopLogger;
import com.dream.qixing.mobile.util.TopUtils;
import com.dream.qixing.mobile.util.WebUtils;
import com.dream.qixing.mobile.util.parse.json.ObjectJsonParser;
import com.dream.qixing.mobile.util.parse.xml.ObjectXmlParser;


/**
 * 基于REST的 客户端。
 */
public class DefaultClient implements Client {

	private static final String FORMAT = "format";
	private static final String METHOD = "method";
	private static final String TIMESTAMP = "timestamp";
	private static final String VERSION = "v";
	private static final String SIGN = "sign";
	private static final String SIGN_METHOD = "signMethod";
	private static final String VENDER_ID = "venderId";
	private static final String REQUEST_TYPE="type";
	private static final String OS="os";
	
	private String venderId;
	private String serverUrl;
	private String appSecret;
	private String format = Constants.FORMAT_JSON;
	private String signMethod = Constants.SIGN_METHOD_MD5;
	private String type=Constants.REQUEST_SOURCE;

	private int connectTimeout = 0;
	private int readTimeout = 0;

	private Boolean needCheckRequest=true;
	
	public DefaultClient(String serverUrl, String venderId, String appSecret) {
		this.venderId = venderId;
		this.appSecret = appSecret;
		this.serverUrl = serverUrl;
	}

	public DefaultClient(String serverUrl, String venderId, String appSecret, String format) {
		this(serverUrl, venderId, appSecret);
		this.format = format;
	}

	public DefaultClient(String serverUrl, String venderId, String appSecret, String format, int connectTimeout, int readTimeout) {
		this(serverUrl, venderId, appSecret, format);
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
	}

	public DefaultClient(String serverUrl, String venderId, String appSecret, String format, int connectTimeout, int readTimeout, String signMethod) {
		this(serverUrl, venderId, appSecret, format, connectTimeout, readTimeout);
		this.signMethod = signMethod;
	}

	public <T extends BaseResponse> T execute(BaseRequest<T> request) throws ApiException {
		BaseParser<T> parser;
		if (Constants.FORMAT_XML.equals(this.format)) {
			parser = new ObjectXmlParser<T>(request.getResponseClass());
		} else {
			parser = new ObjectJsonParser<T>(request.getResponseClass());
		}
		return _execute(request, parser);
	}

	private <T extends BaseResponse> T _execute(BaseRequest<T> request, BaseParser<T> parser) throws ApiException {
		if(needCheckRequest == true){
			try{
				request.check();//if check failed,will throw ApiRuleException.
			}catch(ApiRuleException e){
				T localResponse=null;
				try {
					localResponse = request.getResponseClass().newInstance();
				} catch (InstantiationException e2) {
					throw new ApiException(e2);
				} catch (IllegalAccessException e3) {
					throw new ApiException(e3);
				}
				
				localResponse.setErrorCode(e.getErrCode());
				localResponse.setMsg(e.getErrMsg());
				
				return localResponse;
			}
			
			
		}
		Map<String, Object> rt;
		if(type.equals(request.getTextParams().get(REQUEST_TYPE))){
			rt = doMobilePost(request);
		}else{
			rt = doPost(request);
		}
		
		if (rt == null) return null;

		T tRsp = null;
		try {
			tRsp = parser.parse((String) rt.get("rsp"));
			tRsp.setBody((String) rt.get("rsp"));
			tRsp.setUrl((String) rt.get("url"));
		} catch (RuntimeException e) {
			TopLogger.logBizError((String) rt.get("rsp"));
			throw e;
		}

		tRsp.setParams((PureStringHashMap) rt.get("textParams"));
		if (!tRsp.isSuccess()) {
			TopLogger.logErrorScene(rt, tRsp, venderId);
		}
		return tRsp;
	}

	@SuppressWarnings("unchecked")
	private <T extends BaseResponse> Map<String, Object> doPost(BaseRequest<T> request) throws ApiException {
		Map<String, Object> result = new HashMap<String, Object>();
		RequestParametersHolder requestHolder = new RequestParametersHolder();
		PureStringHashMap appParams = new PureStringHashMap(request.getTextParams());
		requestHolder.setApplicationParams(appParams);

		// 添加协议级请求参数
		PureStringHashMap protocalMustParams = new PureStringHashMap();
		protocalMustParams.put(METHOD, request.getApiMethodName());
		protocalMustParams.put(VERSION, "1.0");
		protocalMustParams.put(VENDER_ID, venderId);
		Long timestamp = request.getTimestamp();// 允许用户设置时间戳
		if (timestamp == null) {
			timestamp = new Date().getTime();
		}
		DateFormat df = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
		df.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIMEZONE));
		protocalMustParams.put(TIMESTAMP, df.format(new Date(timestamp)));// 因为沙箱目前只支持时间字符串，所以暂时用Date格式
		requestHolder.setProtocalMustParams(protocalMustParams);

		PureStringHashMap protocalOptParams = new PureStringHashMap();
		protocalOptParams.put(FORMAT, format);
		protocalOptParams.put(SIGN_METHOD, signMethod);
		requestHolder.setProtocalOptParams(protocalOptParams);

		// 添加签名参数
		try {
			if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
				protocalMustParams.put(SIGN, TopUtils.signTopRequestNew(requestHolder, appSecret, false));
			} else if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {
				protocalMustParams.put(SIGN, TopUtils.signTopRequestNew(requestHolder, appSecret, true));
			} else {
				protocalMustParams.put(SIGN, TopUtils.signTopRequestNew(requestHolder, appSecret, false));
			}
		} catch (IOException e) {
			throw new ApiException(e);
		}

		StringBuffer urlSb = new StringBuffer(serverUrl);
		try {
			String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), WebUtils.DEFAULT_CHARSET);
			String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), WebUtils.DEFAULT_CHARSET);

			urlSb.append("?");
			urlSb.append(sysMustQuery);
			if (sysOptQuery != null & sysOptQuery.length() > 0) {
				urlSb.append("&");
				urlSb.append(sysOptQuery);
			}
			
		} catch (IOException e) {
			throw new ApiException(e);
		}

		String rsp = null;
		try {
			// 是否需要上传文件
			if (request instanceof BaseUploadRequest) {
				BaseUploadRequest<T> uRequest = (BaseUploadRequest<T>) request;
				Map<String, FileItem> fileParams = TopUtils.cleanupMap(uRequest.getFileParams());
				rsp = WebUtils.doPost(urlSb.toString(), appParams, fileParams, connectTimeout, readTimeout);
			} else {
				rsp = WebUtils.doPost(urlSb.toString(), appParams, connectTimeout, readTimeout);
			}
		} catch (IOException e) {
			throw new ApiException(e);
		}
		
		System.out.println(rsp);
		
		result.put("rsp", rsp);
		result.put("textParams", appParams);
		result.put("protocalMustParams", protocalMustParams);
		result.put("protocalOptParams", protocalOptParams);
		result.put("url", urlSb.toString());
		return result;
	}
	private <T extends BaseResponse> Map<String,Object> doMobilePost(BaseRequest<T> request) throws ApiException{
		Map<String, Object> result = new HashMap<String, Object>();
		//应用级参数
		RequestParametersHolder requestHolder = new RequestParametersHolder();
		PureStringHashMap appParams = new PureStringHashMap(request.getTextParams());
		
		requestHolder.setApplicationParams(appParams);
		// 添加协议级请求参数
		PureStringHashMap protocalMustParams = new PureStringHashMap();
		protocalMustParams.put(METHOD, request.getApiMethodName());
		protocalMustParams.put(VENDER_ID, venderId);
		protocalMustParams.put(OS, request.getTextParams().get(OS));
		Long timestamp = request.getTimestamp();// 允许用户设置时间戳
		if (timestamp == null) {
			timestamp = new Date().getTime();
		}
		DateFormat df = new SimpleDateFormat(Constants.DATE_TIME_MOBILE_FORMAT);
		df.setTimeZone(TimeZone.getTimeZone(Constants.DATE_TIME_MOBILE_FORMAT));
		protocalMustParams.put(TIMESTAMP, df.format(new Date(timestamp)));// 因为沙箱目前只支持时间字符串，所以暂时用Date格式
		requestHolder.setProtocalMustParams(protocalMustParams);
		
		PureStringHashMap protocalOptParams = new PureStringHashMap();
		protocalOptParams.put(FORMAT, format);
		protocalOptParams.put(SIGN_METHOD, signMethod);
		requestHolder.setProtocalOptParams(protocalOptParams);

		// 添加签名参数
		try {
			if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {
				protocalMustParams.put(SIGN, TopUtils.signTopMobileRequestNew(requestHolder, appSecret, false));
			} else if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {
				protocalMustParams.put(SIGN, TopUtils.signTopMobileRequestNew(requestHolder, appSecret, true));
			} else {
				protocalMustParams.put(SIGN, TopUtils.signTopMobileRequestNew(requestHolder, appSecret, false));
			}
		} catch (IOException e) {
			throw new ApiException(e);
		}
		

		StringBuffer urlSb = new StringBuffer(serverUrl);
		try {
			String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), WebUtils.DEFAULT_CHARSET);
			String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), WebUtils.DEFAULT_CHARSET);

			urlSb.append("?");
			urlSb.append(sysMustQuery);
			if (sysOptQuery != null & sysOptQuery.length() > 0) {
				urlSb.append("&");
				urlSb.append(sysOptQuery);
			}
			
		} catch (IOException e) {
			throw new ApiException(e);
		}
		String rsp = null;
		try {
			// 是否需要上传文件
			if (request instanceof BaseUploadRequest) {
				BaseUploadRequest<T> uRequest = (BaseUploadRequest<T>) request;
				Map<String, FileItem> fileParams = TopUtils.cleanupMap(uRequest.getFileParams());
				rsp = WebUtils.doPost(urlSb.toString(), appParams, fileParams, connectTimeout, readTimeout);
			} else {
				rsp = WebUtils.doPost(urlSb.toString(), appParams, connectTimeout, readTimeout);
			}
		} catch (IOException e) {
			throw new ApiException(e);
		}
		System.out.println("mobile return result:"+rsp);
		
		result.put("rsp", rsp);
		result.put("textParams", appParams);
		result.put("protocalMustParams", protocalMustParams);
		result.put("protocalOptParams", protocalOptParams);
		result.put("url", urlSb.toString());
		return result;
	}
	public Boolean getNeedCheckRequest() {
		return needCheckRequest;
	}

	public void setNeedCheckRequest(Boolean needCheckRequest) {
		this.needCheckRequest = needCheckRequest;
	}

}
