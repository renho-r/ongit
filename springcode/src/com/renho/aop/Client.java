package com.renho.aop;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.renho.aop.impl.RealService;

public class Client {

	public static void main(String[] args) {
		ClassPathResource classPathResource = new ClassPathResource("springbean/applicationContext.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		System.out.println("numbers: " + defaultListableBeanFactory.getBeanDefinitionCount());
		
		RealService realService = defaultListableBeanFactory.getBean("realService", RealService.class);
		realService.getRenho("test");
	}

}
