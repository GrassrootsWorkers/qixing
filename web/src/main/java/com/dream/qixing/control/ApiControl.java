package com.dream.qixing.control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dream.qixing.Container;
import com.dream.qixing.SpringFactory;
import com.dream.qixing.config.ActionMappings;
import com.dream.qixing.config.InitActionConfig;



/**
 * Api 控制器
 * @author Arron
 *
 */
public class ApiControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String ACTION_NAME = "method";
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	Container.factory = new SpringFactory(WebApplicationContextUtils.
				getRequiredWebApplicationContext(config.getServletContext()));
    	
    	String actionPackages = config.getInitParameter("actionPackages");
    	if (!StringUtils.isEmpty(actionPackages)) {
    		new InitActionConfig(actionPackages.split(",")).buildConfig();
    	}
    	
    }

	public ApiControl() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (isUnCorrectRequest(request)) return; 
		
		Container.getActionInvoaction(ActionMappings.getActionMapping(
				request.getParameter(ACTION_NAME)), request, response).invoke();
	}
	
	private boolean isUnCorrectRequest(HttpServletRequest request) {
		String actionName = request.getParameter(ACTION_NAME);
		
		return StringUtils.isEmpty(actionName);
	}
	
}