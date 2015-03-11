package com.renho.bean;

import static java.lang.String.format;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.renho.bean.pojo.Person;

public class Test {

	@org.junit.Test
	public void mainTest() {
		//ClassPathResource classPathResource1 = new ClassPathResource(null);
		ClassPathResource classPathResource = new ClassPathResource("springbean/beans.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		System.out.println("numbers: " + defaultListableBeanFactory.getBeanDefinitionCount());
		System.out.println("renho:" + defaultListableBeanFactory.getBean("person"));
		
		/*ClassPathResource classPathResource = new ClassPathResource("springbean/beans.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		System.out.println("numbers: " + defaultListableBeanFactory.getBeanDefinitionCount());*/
	}

	@org.junit.Test
	public void otherTest() {
		System.out.println((Person)null);
		format("Initialized %s with PropertySources %s", getClass().getSimpleName(), "a");
	}
	
}
