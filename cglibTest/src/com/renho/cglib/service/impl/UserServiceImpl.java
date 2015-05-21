package com.renho.cglib.service.impl;

import java.util.List;

import com.renho.cglib.dao.IUserDAO;
import com.renho.cglib.pojo.User;
import com.renho.cglib.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDAO userDao;
	
	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public void save(User user) {
		System.out.println("UserServiceImpl save");
		userDao.save(user);
	}

	@Override
	public void delete(User user) {
		System.out.println("UserServiceImpl delete");
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		System.out.println("UserServiceImpl update");
		userDao.update(user);
	}

	@Override
	public List<User> listUser() {
		System.out.println("UserServiceImpl listUser");
		List<User> list = userDao.listUser();
		return list;
	}

}
