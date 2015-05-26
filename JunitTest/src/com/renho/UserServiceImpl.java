package com.renho;

public class UserServiceImpl {
	
	public boolean saveUser(User user) {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		return userDAOImpl.saveUser(user);
	}
}
