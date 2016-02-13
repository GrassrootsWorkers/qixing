package com.dream.qixing.mobile.interceptor;

import com.dream.qixing.mobile.ActionInvocation;

public interface Interceptor {
	
	void intercept(ActionInvocation invocation);
}
