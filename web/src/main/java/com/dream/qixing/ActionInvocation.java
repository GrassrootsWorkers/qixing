package com.dream.qixing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dream.qixing.control.action.ApiActionInterfaces;



public interface ActionInvocation {
	
	ApiActionInterfaces getAction();
	HttpServletRequest getRequest();
	HttpServletResponse getResponse();
	
	void invoke();
	
}
