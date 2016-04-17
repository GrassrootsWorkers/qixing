package com.dream.qixing.interceptor.suport;

import com.dream.qixing.ActionInvocation;
import com.dream.qixing.interceptor.Interceptor;
import com.dream.qixing.util.RequestToBean;

public class ParameterInterceptor implements Interceptor {
	@Override
	public void intercept(ActionInvocation invocation) {
		try{
			RequestToBean.populate(invocation.getRequest(), invocation.getAction());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		invocation.invoke();
	}
	
}
