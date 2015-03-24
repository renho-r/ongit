package com.renho.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class ProgrammeIOC {

	public static void main(String[] args) {
		ClassPathResource cpr = new ClassPathResource("springbean/beans.xml");
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdReader = new XmlBeanDefinitionReader(dlbf);
		xbdReader.loadBeanDefinitions(cpr);
		
		System.out.println("numbers: " + dlbf.getBeanDefinitionCount());
		System.out.println("containsBean:" + dlbf.containsBean("person"));
		System.out.println("isSingleton:" + dlbf.isSingleton("person"));
		System.out.println("isPrototype:" + dlbf.isPrototype("person"));
		System.out.println("isTypeMatch-Object:" + dlbf.isTypeMatch("person", Object.class));
		System.out.println("isTypeMatch-BeanFactory:" + dlbf.isTypeMatch("person", BeanFactory.class));
		System.out.println("getType:" + dlbf.getType("person"));
		System.out.println("getAliases:" + dlbf.getAliases("person").length);
		System.out.println("renho:" + dlbf.getBean("person"));
	}

}
