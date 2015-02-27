package com.renho.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyWrapper extends HttpServletRequestWrapper {

	public MyWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String para = super.getParameter(name);
		return para + " add by wrapper";
	}
}
