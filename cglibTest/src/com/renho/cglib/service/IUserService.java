package com.renho.cglib.service;

import java.util.List;

import com.renho.cglib.pojo.User;

public interface IUserService {

	void save(User user);
	void delete(User user);
	void update(User user);
	List<User> listUser();
	
}
