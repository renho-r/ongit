package com.renho.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ×Ö·û¼¯´¦Àí
 * @author Administrator
 *
 */
public class SetCharacterEncodingFilter implements Filter {

	private FilterConfig config;
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String encoding = config.getInitParameter("encoding");
		if (null != encoding && !"".equals(encoding)) {
			req.setCharacterEncoding(encoding);
			resp.setCharacterEncoding(encoding);
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}

}
