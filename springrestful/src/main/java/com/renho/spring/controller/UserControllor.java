package com.renho.spring.controller;

import javax.servlet.http.HttpServletRequest;

import com.renho.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
>>>>>>> 4ccc284a86f8313770f03de4d90a746fb9a76e4b
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/user")
//@Scope("request")
public class UserControllor {

<<<<<<< HEAD
	@Autowired
	private IUserService userService;

=======
//	@Autowired
	private IUserService userService;

	@Autowired
	private ApplicationContext ac;

	@RequestMapping("/scope")
	@ResponseBody
	public String scope() {
//		return userService.toString();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(ac.getBean("userServiceImpl"));
//			}
//		}).start();
		System.out.println(this.toString());
		System.out.println(ac.getBean("userServiceImpl").toString());
		return ac.getBean("userServiceImpl").toString();
	}

>>>>>>> 4ccc284a86f8313770f03de4d90a746fb9a76e4b
	@RequestMapping(value="/{name}_{id}_{age}", method=RequestMethod.GET)
	@ResponseBody
	public String getUser(@PathVariable String id, @PathVariable String age, @PathVariable String name, HttpServletRequest request) {
		userService.getUser();
		return "获取用户 id:" + id + "---->name:" + name + "---->age:" + age;
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
