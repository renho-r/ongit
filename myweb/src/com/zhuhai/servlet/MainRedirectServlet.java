package com.zhuhai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TicketBusiQueryallServlet
 */
public class MainRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainRedirectServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		HttpSession session = request.getSession();
		session.setAttribute("start", start);
		session.setAttribute("end", end);
		System.out.println("MainRedirectServlet-start:" + start);
		System.out.println("MainRedirectServlet-end:" + end);
		PrintWriter out = response.getWriter();
		out.print("{}");
		out.flush();
		out.close();
	}

}
