package com.renho.cglib.dao.impl;

import java.util.List;

import com.renho.cglib.dao.IUserDAO;
import com.renho.cglib.pojo.User;

public class UserDAOImpl implements IUserDAO {

	@Override
	public void save(User user) {
		System.out.println("UserDAOImpl save");
	}

	@Override
	public void delete(User user) {
		System.out.println("UserDAOImpl delete");
	}

	@Override
	public void update(User user) {
		System.out.println("UserDAOImpl update");
	}

	@Override
	public List<User> listUser() {
		System.out.println("UserDAOImpl listUser");
		return null;
	}

}
