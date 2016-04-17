package com.dream.qixing.interceptor;

import com.dream.qixing.ActionInvocation;

public interface Interceptor {
	
	void intercept(ActionInvocation invocation);
}
