package com.renho.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.renho.wrapper.MyWrapper;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/user/*" }
					,initParams = {
						    @WebInitParam(name = "mood", value = "awake")})
public class UserFilter implements Filter {

	private String mood;
	
    public UserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("UserFilter doFilter");
		System.out.println("initParam name=" + mood);
		chain.doFilter(new MyWrapper((HttpServletRequest) request), response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		mood = fConfig.getInitParameter("mood");
	}

}
