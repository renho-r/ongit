package com.renho.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HttpServletRequestWrapperTest extends HttpServletRequestWrapper {
	
    public HttpServletRequestWrapperTest(HttpServletRequest request) {
        super(request);
        request.setAttribute("t77t77", "ÉñÂíÍæÒâ");
    }
}
