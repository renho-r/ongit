package com.renho.aop.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.renho.aop.auto.service.IRealService;
import com.renho.aop.auto.service.impl.RealService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/springbean/applicationContext-auto.xml");
		
		IRealService iRealService0 = (IRealService) ctx.getBean("realService");
		iRealService0.getRenho("test");
		
//		RealService realService = (RealService) ctx.getBean("realService");
//		realService.getRenho("test");
	}

}
