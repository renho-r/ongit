package com.renho.controller.servlet;

import org.apache.commons.beanutils.BeanUtils;

import com.renho.model.pojo.impl.User;

public class Main {

	public static void main(String[] args) throws Exception {
		User user = new User();
		BeanUtils.copyProperty(user, "userId", 100);
		System.out.println(user.getUserId());
	}

}
