package com.dream.qixing.control.action;

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
	
	public boolean isIsSuccessful();
	
	public void setIsSuccessful(boolean isSuccessful) ;
	
	public Integer getStatusCode();
	
	public  void setStatusCode(Integer code );
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public Integer getUserId();
	
	public void setUserId(Integer userId) ;
}
