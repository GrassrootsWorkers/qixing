package com.dream.qixing.mobile.interceptor.suport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dream.qixing.mobile.ActionInvocation;
import com.dream.qixing.mobile.constants.Constants;
import com.dream.qixing.mobile.interceptor.Interceptor;
import com.dream.qixing.mobile.model.vender.Vender;
import com.dream.qixing.mobile.util.SignUtil;
import com.mysql.jdbc.StringUtils;




/**
 * 检查签名
 * 
 * @author Arron
 * 
 */
public class SignCheckInterceptor implements Interceptor {

	public static final String MULTIPART = "multipart/";
	@Override
	public void intercept(ActionInvocation invocation) {
		Vender vender = new Vender();
		HttpServletRequest request = invocation.getRequest();
		/*String sign = isHasSign(request);

		String type = requestSource(request);
		
		if (Constants.REQUEST_SOURCE.equals(type)) {

			checkTimestamp(request, true);

			checkSign(request, sign, vender, true);

		} else {

			checkTimestamp(request, false);

			checkSign(request, sign, vender, false);

		}*/
	
		invocation.invoke();
	}

	private void checkSign(HttpServletRequest request, String sign,Vender vender, boolean ifMobile) {
		String serverSign = null;

		String signMethod = request.getParameter("signMethod");

		Map<String, Object> param = getParamMap(request);

		serverSign = ifMobile ? makeMobileSign(param, vender, signMethod)
				: makeSign(param, vender, signMethod);

		if (!org.apache.commons.lang.StringUtils.upperCase(sign).equals(serverSign)) {
			throw new RuntimeException(
					"not correct sign. please check secret is correct");
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> getParamMap(HttpServletRequest request) {

		if (request.getContentType() != null
				&& request.getContentType().startsWith(MULTIPART)) {
			return getFormMap(request);
		} else {
			return request.getParameterMap();
		}
	}

	private String makeSign(Map<String, Object> param, Vender vender,String signMethod) {
		String serverSign = null;
		try {
			if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {

				serverSign = SignUtil.makeSign(param, vender.getSecret(), false);

			} else if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {

				serverSign = SignUtil.makeSign(param, vender.getSecret(), true);

			} else {

				serverSign = SignUtil
						.makeSign(param, vender.getSecret(), false);

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return serverSign;
	}

	private String makeMobileSign(Map<String, Object> param, Vender vender,String signMethod) {
		String serverSign = null;
		StringBuffer data = new StringBuffer();
		/*
		 * String value=null; for (Entry<String, Object> param : paramSet) { if
		 * (param.getValue().getClass().isArray()) { value = ( (String[])
		 * param.getValue() )[0]; } else { value = param.getValue().toString();
		 * } }
		 */

		data.append("os=").append(((String[]) param.get("os"))[0]).append("&")
				.append("timestamp=")
				.append(((String[]) param.get("timestamp"))[0]).append("&")
				.append("appkey=").append(vender.getSecret());
		System.out.println(data.toString());
		try {
			if (Constants.SIGN_METHOD_MD5.equals(signMethod)) {

				serverSign = SignUtil.byte2hex(SignUtil.encryptMD5(data
						.toString()));

			} else if (Constants.SIGN_METHOD_HMAC.equals(signMethod)) {

				serverSign = SignUtil.byte2hex(SignUtil.encryptHMAC(
						data.toString(), vender.getSecret()));

			} else {

				serverSign = SignUtil.byte2hex(SignUtil.encryptMD5(data
						.toString()));

			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return serverSign;
	}

	private Vender checkVender(HttpServletRequest request) {
		String venderId = request.getParameter("venderId");
		if (StringUtils.isNullOrEmpty(venderId)) {
			throw new RuntimeException("need vender id");
		}
		Vender vender = new Vender();
		if (vender == null) {
			throw new RuntimeException("need vender id");
		}
		return vender;
	}

	private void checkTimestamp(HttpServletRequest request, boolean ifMobile) {
		String stringTimestamp = request.getParameter("timestamp");

		if (StringUtils.isNullOrEmpty(stringTimestamp)) {
			throw new RuntimeException("need vender timestamp");
		}
		SimpleDateFormat simpleFormat = new SimpleDateFormat(
				ifMobile ? Constants.DATE_TIME_MOBILE_FORMAT
						: Constants.DATE_TIME_FORMAT);
		simpleFormat.setTimeZone(TimeZone
				.getTimeZone(ifMobile ? Constants.DATE_TIME_MOBILE_FORMAT
						: Constants.DATE_TIME_FORMAT));
		long timestamp;
		try {
			timestamp = simpleFormat.parse(stringTimestamp).getTime();
		} catch (ParseException e1) {
			e1.printStackTrace();
			throw new RuntimeException("not correct time:" + stringTimestamp);
		}

		long toplimit = System.currentTimeMillis() + (24 * 6 * 10 * 60 * 1000);
		long floor = System.currentTimeMillis() - (24 * 6 * 10 * 60 * 1000);

		if (timestamp > toplimit || timestamp < floor) {
			throw new RuntimeException(
					" timestamp No upper limit in ten minutes");
		}
	}

	private String isHasSign(HttpServletRequest request) {
		String sign = request.getParameter("sign");
		if (StringUtils.isNullOrEmpty(sign)) {
			throw new RuntimeException(
					"not correct sign. please check secret is correct");
		}
		return sign;
	}

	private String requestSource(HttpServletRequest request) {
		String type = request.getParameter("type");
		return type;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFormMap(HttpServletRequest request) {

		return null;
	}

	private void insertOperateLog(HttpServletRequest request) {
	
	}



}
