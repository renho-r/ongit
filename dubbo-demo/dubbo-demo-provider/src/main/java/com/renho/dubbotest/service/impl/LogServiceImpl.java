package com.renho.dubbotest.service.impl;

import com.renho.dubbotest.service.ILogService;

public class LogServiceImpl implements ILogService {

	public String log(String msg) {

		System.out.println("log ok");

		return msg;
	}

}
