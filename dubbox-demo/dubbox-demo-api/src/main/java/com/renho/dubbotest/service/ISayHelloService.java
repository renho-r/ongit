package com.renho.dubbotest.service;

import com.renho.dubbotest.domain.User;

public interface ISayHelloService {

	String regist(User user);

	User getUser(String id);
	
}
