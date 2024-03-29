package com.renho.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renho.MyChatAnnotation;

public class SendToRenho2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyChatAnnotation myChatAnnotation = MyChatAnnotation.connections.get("renho2");
		myChatAnnotation.getSession().getBasicRemote().sendText("msg from servlet");
	}
	
	

}
