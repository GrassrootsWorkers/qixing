package com.dream.qixing.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dream.qixing.constants.Constants;
import com.dream.qixing.mapping.ApiField;
import com.opensymphony.xwork2.ActionSupport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 所有ACTION的基类
 *
 * @version $Revision$
 *
 */
public abstract class BaseAction extends ActionSupport implements ApiActionInterfaces {

	private static final long serialVersionUID = -7957586334286020630L;

	public static final int MAX_PAGE_SIZE = 100;

	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * 页码 : 取值范围 大于零的整数， 默认值 1
	 */
	private Integer pageNo;

	/**
	 * 每页显示的条数：最大200，默认值：20
	 */
	private Integer pageSize;

	protected String format;

	private String timestamp;

	private String fields;

	private String vendorId;

	
	private boolean isSuccessful;// :true,
	
	private Integer statusCode;// ":200,

	private String description;//

	private Integer userId;
	/**
	 * 请求的来源 mobile --手机客户端 open--开放平台
	 */
	private String type;

	private String os;

	@ApiField("token")
	protected String token;

	@ApiField("security")
	protected String security;

	@ApiField("msg")
	private String msg;
	protected   boolean validateMobile(String mobile){
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	public String getFormat() {
		if (format == null || (!Constants.FORMAT_JSON.equals(format) && !Constants.FORMAT_XML.equals(format))) {
			format = Constants.FORMAT_JSON;
		}

		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 得到HttpRequest
	 * 
	 * @return 获得的HttpRequest
	 */
	public HttpServletRequest getRequest() {
		return request == null ? ServletActionContext.getRequest() : request;
	}

	/**
	 * 得到HttpSession
	 * 
	 * @return 获得的HttpSession
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 得到HttpResponse
	 * 
	 * @return 获得的HttpResponse
	 */
	public HttpServletResponse getResponse() {
		return response == null ? ServletActionContext.getResponse() : response;
	}

	/**
	 * 得到上下文路径，例如：/mylearningii
	 * 
	 * @return 上下文路径
	 */
	public String getContext() {
		return getRequest().getContextPath();
	}

	/**
	 * 得到服务全路径，例如：http://127.0.0.1:8080/mylearningii
	 * 
	 * @return 服务全路径
	 */
	public String getBasePath() {
		String path = getRequest().getContextPath();
		String basePath = getRequest().getScheme() + "://" + getRequest().getServerName();

		if (getRequest().getServerPort() != 80) {
			basePath += ":" + getRequest().getServerPort() + path;
		} else {
			basePath += path;
		}

		return basePath;
	}

	/**
	 * 得到应用的绝对地址，例如：D:\Eclipse\workspace\CourseCreater\web\
	 * 
	 * @return 应用的绝对地址
	 */
	public String getRealPath() {
		return getRequest().getSession().getServletContext().getRealPath("/");
	}

	/**
	 * 获得用户的真实IP
	 *
	 * @return 用户的真实IP
	 */
	public String getRealIP() {
		String ip = getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getRemoteAddr();
		}

		return ip;
	}

	/**
	 * 获得请求的referer
	 * 
	 * @return referer
	 */
	public String getReferer() {
		String referer = getRequest().getHeader("referer");
		if (referer != null && !referer.equalsIgnoreCase("")) {
			referer = referer.substring(0, referer.lastIndexOf("/") + 1);
		} else {
			referer = "";
		}

		return referer;
	}

	// ================================== get/set
	// ===================================

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public Integer getPageNo() {
		return (pageNo == null || pageNo < 1) ? 1 : pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		// 解决"获取在售商品 只能 获取到20条"(20改为100)
		return (pageSize == null || pageSize < 1 || pageSize > MAX_PAGE_SIZE) ? 100 : pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	@Override
	public boolean isIsSuccessful() {
		return isSuccessful;
	}

	@Override
	public void setIsSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public Integer getStatusCode() {
		return statusCode;
	}

	@Override
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
}
