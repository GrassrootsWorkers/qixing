package com.dream.qixing.mobile;

import com.dream.qixing.mobile.config.ActionMapping;
import com.dream.qixing.mobile.control.action.ApiActionInterfaces;

public abstract class Factory {
	
	public abstract ApiActionInterfaces buildAction(ActionMapping actionMapping);
	
	public abstract Object get(String beanName);
}	
