package com.renho.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.renho.service.CityService;
import com.renho.spring.renho.service.CountryService;


public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet111111111");
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
		}else if("CountryService".equals(method)) {
			CountryService countryService = (CountryService)wac.getBean("countryService");
			countryService.find();
		}else if("uploadFile".equals(method)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String method = request.getParameter("method");
		if("uploadFile".equals(method)) {
			upload(request, response);
		}
	}
	
	protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName");
		System.out.println(fileName);
		InputStream in = request.getInputStream();
		byte[] bytes = new byte[1024];
		int n = -1;
		while(-1 != (n=in.read(bytes))) {
			System.out.write(bytes, 0, n);
		}
		in.close();
	}

}
