package com.dream.qixing.mobile.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ApiActionInterfaces {
	
	public String execute() throws Exception;
	
	public void setRequest(HttpServletRequest request);
	
	public void setResponse(HttpServletResponse response);
	
	public String getResponseName();
	
	public String getFormat();
	
	public String getFields();
	
	public void setMsg(String msg);
	
	public  String getType();
	
	public boolean isIssuccessful();
	
	public void setIssuccessful(boolean issuccessful) ;
	
	public Integer getStatuscode();
	
	public  void setStatuscode(Integer code );
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public String getUserId();
	
	public void setUserId(String userId) ;
}
