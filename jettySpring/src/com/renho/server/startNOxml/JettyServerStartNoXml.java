package com.renho.server.startNOxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JettyServerStartNoXml {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
