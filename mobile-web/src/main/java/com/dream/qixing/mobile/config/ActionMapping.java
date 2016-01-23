package com.dream.qixing.mobile.config;

import java.util.Collections;
import java.util.List;

import com.dream.qixing.mobile.interceptor.Interceptor;





public class ActionMapping{
	private String actionName;
	private Class<?> actionClass;
	private List<Interceptor> intercetors = Collections.emptyList();
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public Class<?> getActionClass() {
		return actionClass;
	}
	public void setActionClass(Class<?> actionClass) {
		this.actionClass = actionClass;
	}
	public List<Interceptor> getIntercetors() {
		return intercetors;
	}
	public void setIntercetors(List<Interceptor> intercetors) {
		this.intercetors = intercetors;
	}
	
}