package com.renho.jsonpserver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

@WebServlet("/userServletJsonp")
public class UserServletJsonp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setId(100);
		user.setName("renho");
		String jsonpCallback = request.getParameter("jsonpCallback");
		JSONObject backJson = JSONObject.fromObject(user);
		PrintWriter out = response.getWriter();
		out.print(jsonpCallback + "(" + backJson.toString() + ")");
		
	}

}
