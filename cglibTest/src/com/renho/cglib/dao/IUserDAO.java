package com.renho.cglib.dao;

import java.util.List;

import com.renho.cglib.pojo.User;

public interface IUserDAO {

	void save(User user);
	void delete(User user);
	void update(User user);
	List<User> listUser();
}
