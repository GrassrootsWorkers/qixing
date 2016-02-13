package com.dream.qixing.mobile.control.helper;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterSetEncodingFilter implements Filter {
	

	private String encode;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain arg2) throws IOException, ServletException {
		if( encode != null ){
			req.setCharacterEncoding(encode);
			req.getParameterMap();
			System.out.println( req.getParameter("bjbxkjc") );
			System.out.println(Thread.currentThread().getName() + "*******************begin");
		}
		arg2.doFilter(req, res);
		
		
		System.out.println(Thread.currentThread().getName() + "*******************end");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encode");
	}

}
