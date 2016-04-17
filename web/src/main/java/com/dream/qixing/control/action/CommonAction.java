/*
 * 文件名： CommonAction.java
 * 
 * 创建日期： 2010-4-16
 *
 * Copyright(C) 2010, by xiaozhi.
 *
 * 原始作者: <a href="mailto:xiaozhi19820323@hotmail.com">xiaozhi</a>
 *
 */
package com.dream.qixing.control.action;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.dream.qixing.constants.Global;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.dream.qixing.config.ReloadableConfig;


/**
 * 所有ACTION的基类，提供操作Session对象的方法。
 * 
 * @version $Revision$
 * 
 */
public abstract class CommonAction extends BaseAction {
	
	public static final String JSON = "json";
	public static final String HTML = "html";
	private static final Logger log = Logger.getLogger(CommonAction.class);
	
	private static final long serialVersionUID = -5289611895238514280L;

	private static String APP_DOMAIN;

	static {
		APP_DOMAIN = ReloadableConfig.getProperty("app_domain", "openadmin.111.com");
	}
	
	public String getAppDomain(){
		return APP_DOMAIN;
	}
	
	protected String dataType;
	
	protected boolean isSpecifyDataType() {
		return false;
	}
	
	/**
	 * 得到UserSessionObj
	 * 
	 * @return 获得的UserSessionObj
	 */
	public String getUserSessionInfo() {
		return (String) ServletActionContext.getRequest().getSession()
				.getAttribute("username");
	}

	/**
	 * 保存UserSessionObj到用户的Session中，并同步OnlineUserMap。
	 * 
	 * @param sessionObj
	 *            要保存的UserSessionObj
	 */
	public void setUserSessionInfo(String username) {
		ServletActionContext.getRequest().getSession().setAttribute("username",
				username);
	}

	/**
	 * 清除用户的Session中的UserSessionObj。
	 * 
	 */
	public void clearUserSessionInfo() {
		ServletActionContext.getRequest().getSession().setAttribute("username",
				null);
	}

	/**
	 * 后台得到UserSessionObj
	 * 
	 * @return 获得的UserSessionObj
	 */

	
	public void addToSession(String key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	/**

	/**
	 * 后台清除用户的Session中的UserSessionObj。
	 * 
	 */
	public void clearAdminSessionInfo() {
		ServletActionContext.getRequest().getSession().setAttribute(
				"admin", null);
		getSession().invalidate();
	}


	/**
	 * 加入值到cookies里
	 * 
	 * @param key
	 *            键
	 * 
	 * @param value
	 *            值
	 */
	public void addCookie(String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/");// 这个要设置
		// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
		cookie.setMaxAge(365 * 24 * 60 * 60);
		this.getResponse().addCookie(cookie);
	}

	public void addCookie(String key, String value, int time) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/");// 这个要设置
		// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
		cookie.setMaxAge(time);
		this.getResponse().addCookie(cookie);
	}

	public void addCookie(String key, String value, String domain) {
		addCookie(key, value , domain , (365 * 24 * 60 * 60));
	}
	
	public void addCookie(String key, String value, String domain, int time) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/");// 这个要设置
		// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
		cookie.setMaxAge(time);
		cookie.setDomain(domain);
		this.getResponse().addCookie(cookie);
	}

	/**
	 * 根据键获取对应的cookie对象
	 * 
	 * @param key
	 *            对应的key
	 * 
	 * @return key对应的cookie值
	 */
	public Cookie getCookie(String key) {
		Cookie[] cookies = this.getRequest().getCookies();
		if (cookies == null || cookies.length < 1)
			return null;
		for (Cookie temp : cookies) {
			if (temp.getName().equals(key)) {
				return temp;
			}
		}
		return null;
	}
	

	/**
	 * 获得cookie对应的值
	 * 
	 * @param key
	 *            对应的键
	 * 
	 * @return 返回值
	 */
	public String getCookieValue(String key) {
		Cookie cookie = this.getCookie(key);
		if (cookie != null) {
			try {
				return URLDecoder.decode(cookie.getValue(), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void clearCookie(String key) {
		Cookie cookie = new Cookie(key, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		this.getResponse().addCookie(cookie);
	}
	

	/**
	 * 获得session中的user
	 * 
	 * @return
	 */
	/*public User getUser() {
		UserSessionObj userObj = getUserSessionInfo();
		if (userObj == null)
			return null;

		User user = userObj.getUser();
		if (user == null)
			return null;

		return user;

	}
	*/

	
	/**
	 * 获取管理员后台操作员姓名
	 * 
	 * @return
	 */
	protected String getAdminSessionOperator() {
		try {
			return getSession().getAttribute("username").toString();
		} catch (Exception ex) {
			return "";
		}
	}
	
	/**
	 * 将公司ID保存到session中
	 * @param comp_id
	 */
	protected void setAdminSessionCOMPID(String comp_id) {
		 getSession().setAttribute(Global.ADMIN_SESSION_COMP_ID, comp_id);
	}
	
	/**
	 * 获取session中公司ID
	 * @return
	 */
	protected String getAdminSessionCOMPID() {
		return (String)getSession().getAttribute(Global.ADMIN_SESSION_COMP_ID);
	}
	
	/**
	 * 将城市ID集合字符串保存到session中
	 * @param city_ids
	 */
	protected void setAdminSessionCITYIDS(String city_ids) {
		 getSession().setAttribute(Global.ADMIN_SESSION_CITY_IDS, city_ids);
	}
	
	/**
	 * 获取session中城市ID集合字符串
	 * @return
	 */
	protected String getAdminSessionCITYIDS() {
		return (String)getSession().getAttribute(Global.ADMIN_SESSION_CITY_IDS);
	}
	

	protected void setLastQueryString() {
		String requesturl = this.getRequest().getQueryString();
		this.getSession().setAttribute("lasturl", requesturl);
	}

	protected String getLastQueryString() {
		Object lastRequesturl = this.getSession().getAttribute("lasturl");
		if (lastRequesturl != null)
			return (String) lastRequesturl;
		return "";
	}

	protected void removeLastQueryString() {
		this.getSession().removeAttribute("lasturl");
	}
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	
	protected void writeAjaxStr(String str){
		HttpServletResponse response = this.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("GBK");
		try {
			PrintWriter out = response.getWriter();
			out.write(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeJson(String str) {
		str = str == null ? "" : str;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			PrintWriter out = response.getWriter();
			out.write(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String getUserVenderId() {
		return getSession().getAttribute("venderId").toString();
	}
	
	protected String getUserVenderId(boolean isFirst) {
		return isFirst ? getUserVenderId().split(",")[0] : getUserVenderId();
	}
	
	public String getVenderId() {
		return ReloadableConfig.getProperty("yao_venderid", "2011102716210000");
	}
	
	public String getErpContanctIp()
	{
		return ReloadableConfig.getProperty("Erp_contract_interface", "http://10.128.11.198/");
	}
	
	public boolean isYaoVender(String venderId) {
		return getVenderId().endsWith(venderId);
	}
	
	public boolean isControlCenter() {
		if (StringUtils.isEmpty(getAdminSessionCOMPID())) return false;
		
		return getAdminSessionCOMPID().equals(ReloadableConfig.getProperty("header_company_id", ""));
	}
	
	
	public String getConnection(String url, String parameter,String charset) {
		if(charset==null) charset="UTF-8";
		log.info("链接开始url：" + url + "参数为：" + parameter);
		String s = "0";
		try {
			URL postUrl = new URL(url);
			// 打开连接
			HttpURLConnection connection = (HttpURLConnection) postUrl
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setReadTimeout(30000);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection
					.getOutputStream());
			if (!StringUtils.isEmpty(parameter))
				out.writeBytes(parameter);
			out.flush();
			out.close(); // flush and close
			int code = connection.getResponseCode();
			if (code == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream(),charset));
				s = reader.readLine();
				log.info("链接开始url：" + url + "---参数为：" + parameter + "---结果："
						+ s);
			} else {
				log.info("链接开始url：" + url + "---参数为：" + parameter
						+ "---结果建立连接出错---" + code);
			}

		} catch (Exception e) {
			log.info("链接出现问题~！！！！！！");
		}
		return s;

	}

}
