package com.dream.qixing.config;

import java.util.List;

import com.dream.qixing.Container;
import com.dream.qixing.interceptor.InterceptorRef;
import com.dream.qixing.util.ClassUtils;
import org.apache.log4j.Logger;


public class InitActionConfig {
	private static Logger LOG = Logger.getLogger(InitActionConfig.class);
	
	private String[] actionPackages = {};
	
	public InitActionConfig() {
	}
	
	public InitActionConfig(String[] actionPackages) {
		if (actionPackages == null) return; 
		
		this.actionPackages = actionPackages;
	}
	
	public void buildConfig() {
		for (String actionPackage : actionPackages) {
			initActionMappingClass(actionPackage.trim());
		}
	}
	
	public void initActionMappingClass(String actionPackage) {
		List<Class<?>> classList = ClassUtils.getClasses(actionPackage);
		
		for (Class<?> c : classList) {
			if (!c.isAnnotationPresent(ApiAction.class)) continue;
			buildActionMap(c);
		}
	}
	
	public void buildActionMap(Class<?> actionClass) {
		if (LOG.isInfoEnabled()) {
			LOG.info("scan action config:" + actionClass.getName());
		}
		ApiAction apiAction = actionClass.getAnnotation(ApiAction.class);
		
		ActionMappings.put(apiAction.value(), actionClass);
		ApiIntercetorRef interceptor = apiAction.interceptorRef();
		
		if (interceptor == null || "".equals(interceptor.value())) return;
		
		InterceptorRef interceptorRef = (InterceptorRef)
			Container.factory.get(interceptor.value());
		
		if (interceptorRef == null || interceptorRef.getIntercetors() == null) return;
		
		ActionMappings.put(apiAction.value(), interceptorRef.getIntercetors());
	}
	
	public static void main(String[] s){
		new InitActionConfig(new String[]{"com.yao.open.control.action"}).buildConfig();
	}
}
