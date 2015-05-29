package com.renho.server.startxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SuppressWarnings("unused")
public class JettyServerStartNoXml {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		//new ClassPathXmlApplicationContext("applicationContext0.xml");
		new FileSystemXmlApplicationContext("web/WEB-INF/spring/applicationContext.xml");
	}

}
