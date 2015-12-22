package com.renho.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsRequestTest")
public class JsRequestTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsRequestTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("renho", "020301");
		request.getRequestDispatcher("/test/testJsRequest.jsp").forward(request, response);
	}

}
