package com.renho.simulateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renho.simulateservice.SimulateService;

@WebServlet("/hascache/renho")
public class SimulateServletHasCache extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SimulateService ss = new SimulateService();
		resp.getWriter().print(ss.getTime());
		resp.getWriter().close();
	}

}
