package com.renho.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import com.renho.cglib.dao.impl.UserDAOImpl;
import com.renho.cglib.pojo.User;
import com.renho.cglib.proxy.UserServiceCallbackFilter;
import com.renho.cglib.proxy.UserServiceProxy;
import com.renho.cglib.service.impl.UserServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		User user = new User();
		
		Enhancer en = new Enhancer();     
		//���д���     
		en.setSuperclass(UserServiceImpl.class);
		UserServiceProxy userServiceProxy = new UserServiceProxy(); 
//		en.setCallback(userServiceProxy);     
		en.setCallbacks(new Callback[]{userServiceProxy, NoOp.INSTANCE});     
		en.setCallbackFilter(new UserServiceCallbackFilter());
		 
		 
		 //���ɴ���ʵ��     
		UserServiceImpl userServiceImpl =  (UserServiceImpl) en.create();
		userServiceImpl.setUserDao(new UserDAOImpl());
		userServiceImpl.save(user);
		userServiceImpl.delete(user);
		userServiceImpl.update(user);
		userServiceImpl.listUser();
		
//		en.set
	}

}
