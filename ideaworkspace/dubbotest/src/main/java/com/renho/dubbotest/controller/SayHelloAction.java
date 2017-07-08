package com.renho.dubbotest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.renho.dubbotest.service.ISayHelloService;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
@RequestMapping(value="/sayHello")
public class SayHelloAction {

	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	@ResponseBody
	public String sayHello(@PathVariable String name, HttpServletRequest request) {

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		ISayHelloService sayHelloService = (ISayHelloService) context.getBean("sayHelloService");
		return sayHelloService.sayHello(name);
	}

}
