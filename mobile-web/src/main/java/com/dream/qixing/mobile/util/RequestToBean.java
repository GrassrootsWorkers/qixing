package com.dream.qixing.mobile.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtilsBean;


public abstract class RequestToBean {
	static BeanUtilsBean beanUtils;
	static{
		beanUtils = BeanUtilsBean.getInstance();
		beanUtils.getConvertUtils().register(
				new org.apache.commons.beanutils.converters.SqlTimestampConverter(), 
				java.util.Date.class);
	}
	
	@SuppressWarnings("unchecked")
	public static void populate(HttpServletRequest request, Object obj) {   
	    Map map = request.getParameterMap();   
	    try {   
	    	beanUtils.populate(obj, map);   
	    } catch (IllegalAccessException e) {   
	      e.printStackTrace();   
	    } catch (InvocationTargetException e) {   
	      e.printStackTrace();   
	    }   
	  } 
}
