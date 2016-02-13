package com.dream.qixing.mobile.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface ApiAction {
	
	/**api-action 类映射名称*/
	public String value() default "";
	
	public ApiIntercetorRef interceptorRef() default @ApiIntercetorRef("baseInterceptor");
}