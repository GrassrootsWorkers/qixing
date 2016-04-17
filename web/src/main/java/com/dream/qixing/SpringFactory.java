package com.dream.qixing;

import com.dream.qixing.control.action.ApiActionInterfaces;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.dream.qixing.config.ActionMapping;


public class SpringFactory extends Factory {
	
	private AutowireCapableBeanFactory autowireContext;
	private ApplicationContext context;
	
	public SpringFactory(ApplicationContext context) {
		this.context = context;
		autowireContext = findAutoWiringBeanFactory(context);
	}
	
	public Object get(String beanId) {
		return context.getBean(beanId);
	}
	
	@Override
	public ApiActionInterfaces buildAction(ActionMapping actionMapping) {
		if (actionMapping == null || actionMapping.getActionClass() == null)
			return null;
		
		return (ApiActionInterfaces) autowireContext.createBean(
				actionMapping.getActionClass(), AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}
	
	private AutowireCapableBeanFactory findAutoWiringBeanFactory(ApplicationContext context) {
        if (context instanceof AutowireCapableBeanFactory) {
            // Check the context
            return (AutowireCapableBeanFactory) context;
        } else if (context instanceof ConfigurableApplicationContext) {
            // Try and grab the beanFactory
            return ((ConfigurableApplicationContext) context).getBeanFactory();
        } else if (context.getParent() != null) {
            // And if all else fails, try again with the parent context
            return findAutoWiringBeanFactory(context.getParent());
        }
        return null;
    }
}
