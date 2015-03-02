package com.renho.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.renho.service.CityService;


public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String method = request.getParameter("method");
		System.out.println(method);
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		CityService cityService = (CityService)wac.getBean("cityService");
		if("find".equals(method)) {
			cityService.find();			
		}else if("add".equals(method)) {
			cityService.addCity();
		}else if("delete".equals(method)) {
			cityService.deleteByName("renho");
		}else if("update".equals(method)) {
			cityService.updateCity();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
	}

}
