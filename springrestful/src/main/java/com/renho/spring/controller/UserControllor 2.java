package com.renho.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renho.spring.pojo.User;

@Controller
@RequestMapping(value="/user")
public class UserControllor {

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable Integer id, HttpServletRequest request) {
		User user = new User();
		user.setId(id);
		user.setName("中文");
		return user;
	}
	
	@RequestMapping(value="/string/{name}_{id}_{age}", method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable String id, @PathVariable String age, @PathVariable String name, HttpServletRequest request) {
		return "id:" + id + "---->name:中文" + name + "---->age:" + age;
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
