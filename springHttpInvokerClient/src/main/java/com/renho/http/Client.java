package com.renho.http;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	    IRemoteService service = (IRemoteService) applicationContext.getBean("iRemoteTest");
	    service.startRmote();
	}

}
