package com.dream.qixing.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dream.qixing.interceptor.Interceptor;
import org.apache.commons.lang.StringUtils;


public abstract class ActionMappings {
	
	private static Map<String, ActionMapping> actionMapping = 
				new HashMap<String, ActionMapping>();
	
	public static void put(String actionName, 
			Class<?> actionClass) {
		
		if (StringUtils.isEmpty(actionName) || (actionClass == null)) return;
		
		ActionMapping am = getActionMappingWhenNullCreate(actionName);
		am.setActionName(actionName);
		am.setActionClass(actionClass);
		
		actionMapping.put(actionName, am);
	}
	
	public static void put(String actionName, 
			List<Interceptor> interceptors) {
		
		if (StringUtils.isEmpty(actionName) || (interceptors == null)) return;
		
		ActionMapping am = getActionMappingWhenNullCreate(actionName);
		am.setActionName(actionName);
		am.setIntercetors(interceptors);
		
		actionMapping.put(actionName, am);
	}
	
	public static Class<?> get(String actionName) {
		if (StringUtils.isEmpty(actionName)) return null;
		
		return getActionMappingWhenNullCreate(actionName).getActionClass();
	}
	
	public static ActionMapping getActionMappingWhenNullCreate(String actionName) {
		ActionMapping am = null;
		
		if ((am = actionMapping.get(actionName)) == null) {
			am = new ActionMapping();
			actionMapping.put(actionName, am);
		}
		
		return am;
	}
	
	public static ActionMapping getActionMapping(String actionName) {
		return actionMapping.get(actionName);
	}
	
}
