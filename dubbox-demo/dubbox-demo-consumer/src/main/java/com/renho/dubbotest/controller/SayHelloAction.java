package com.renho.dubbotest.controller;

import javax.servlet.http.HttpServletRequest;

import com.renho.dubbotest.domain.User;
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
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping(value="/user")
public class SayHelloAction {

	private AtomicLong count = new AtomicLong(0);

	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public User sayHello(@PathVariable String id, HttpServletRequest request) {
		Long thisCount = count.addAndGet(1);
		System.out.println(thisCount);
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		ISayHelloService sayHelloService = (ISayHelloService) context.getBean("sayHelloService");
		User user = sayHelloService.getUser(id);
		return user;
	}

}
