package com.renho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CharEncodingTest
 */
@WebServlet("/charEncodingTest")
public class CharEncodingTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CharEncodingTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		
		System.out.println(request.getCharacterEncoding());
		System.out.println(request.getQueryString());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getServerName());
		System.out.println(request.getServletPath());
		System.out.println(request.getCookies());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
