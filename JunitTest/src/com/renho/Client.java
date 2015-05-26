package com.renho;

public class Client {

	public static void main(String[] args) {
		User user = new User();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.saveUser(user);
	}

}
