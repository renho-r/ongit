package com.renho.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.renho.aop.xml.service.ExtendedInterface;
import com.renho.aop.xml.service.IRealService;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/springbean/applicationContext.xml");
		
		IRealService iRealService0 = (IRealService) ctx.getBean("realService");
		iRealService0.getRenho("testargs");
		iRealService0.getRenhoThrowException("test exception renho");
		
//		ExtendedInterface extendedInterface = (ExtendedInterface) ctx.getBean("realService");
//		extendedInterface.extendedExecute();
	}

}
