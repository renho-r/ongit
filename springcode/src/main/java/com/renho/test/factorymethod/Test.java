package com.renho.test.factorymethod;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.renho.bean.dao.PersonDAO;

public class Test {

	public static void main(String[] args) {
		ClassPathResource classPathResource = new ClassPathResource("springbean/factorymethod.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		//LoginAction loginAction = (LoginAction) defaultListableBeanFactory.getBean("loginAction");
		//loginAction.execute();
		PersonDAO personDAO = (PersonDAO) defaultListableBeanFactory.getBean("personDAO");
		System.out.println(personDAO.getPerson().getPersonName());
	}
}
