package com.dream.qixing;

import com.dream.qixing.config.ActionMapping;
import com.dream.qixing.control.action.ApiActionInterfaces;

public abstract class Factory {
	
	public abstract ApiActionInterfaces buildAction(ActionMapping actionMapping);
	
	public abstract Object get(String beanName);
}	
