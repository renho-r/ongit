package com.renho.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
public class UserControllor {

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable Long id, HttpServletRequest request) {
		return "获取用户 id:" + id;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public String addUser(HttpServletRequest request) {
		return "增加用户 id:" + request.getParameter("id") + "\r\nname:" + request.getParameter("name");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(HttpServletRequest request) {
		return "修改用户 id:" + request.getParameter("id") + "\r\nname:" + request.getParameter("name");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public String delUser(@PathVariable Long id, HttpServletRequest request) {
		return "删除用户 id:" + id;
	}
}
