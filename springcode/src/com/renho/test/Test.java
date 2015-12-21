package com.renho.test;

import static java.lang.String.format;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResourceLoader;

import com.renho.bean.pojo.Person;

public class Test {

	@org.junit.Test
	public void mainTest() {
		//ClassPathResource classPathResource1 = new ClassPathResource(null);
//		ClassPathResource classPathResource = new ClassPathResource("springbean/beans.xml");
//		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
//		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
//		System.out.println("numbers: " + defaultListableBeanFactory.getBeanDefinitionCount());
////		System.out.println("containsBean:" + defaultListableBeanFactory.containsBean("person"));
////		System.out.println("isSingleton:" + defaultListableBeanFactory.isSingleton("person"));
////		System.out.println("isPrototype:" + defaultListableBeanFactory.isPrototype("person"));
////		System.out.println("isTypeMatch-Object:" + defaultListableBeanFactory.isTypeMatch("person", Object.class));
////		System.out.println("isTypeMatch-BeanFactory:" + defaultListableBeanFactory.isTypeMatch("person", BeanFactory.class));
////		System.out.println("getType:" + defaultListableBeanFactory.getType("person"));
////		System.out.println("getAliases:" + defaultListableBeanFactory.getAliases("person").length);
//		System.out.println("renho:" + defaultListableBeanFactory.getBean("person"));
//		System.out.println("renho:" + defaultListableBeanFactory.getBean("lazyinitPerson"));
		ClassPathResource classPathResource = new ClassPathResource("springbean/beans.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		System.out.println("numbers: " + defaultListableBeanFactory.getBeanDefinitionCount());
//		FileSystemXmlApplicationContext
	}

	@org.junit.Test
	public void otherTest() {
		System.out.println((Person)null);
		format("Initialized %s with PropertySources %s", getClass().getSimpleName(), "a");
	}
	
}
