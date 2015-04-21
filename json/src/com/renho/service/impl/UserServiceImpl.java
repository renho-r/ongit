package com.renho.service.impl;

import com.renho.model.dao.IUserDAO;
import com.renho.model.pojo.impl.User;
import com.renho.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;
	
	@Override
	public int save(User user) {
		return userDAO.save(user);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
