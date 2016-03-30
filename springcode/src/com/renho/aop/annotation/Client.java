package com.renho.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.renho.aop.annotation.service.IService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/springbean/applicationContext-aop-annotation.xml");
		
		IService service = (IService) ctx.getBean("service");
		service.show();
		service.nonAnnotation();
		
	}

}
