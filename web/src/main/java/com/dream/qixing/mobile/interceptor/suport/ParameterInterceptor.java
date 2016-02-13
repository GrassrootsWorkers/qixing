package com.dream.qixing.mobile.interceptor.suport;

import com.dream.qixing.mobile.ActionInvocation;
import com.dream.qixing.mobile.interceptor.Interceptor;
import com.dream.qixing.mobile.util.RequestToBean;

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
