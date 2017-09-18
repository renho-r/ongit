package com.renho.test.filexmlappcontext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestFileXmlAppContext {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext fsxac = new FileSystemXmlApplicationContext("src/springbean/beans.xml");
		fsxac.getBean("person");
		fsxac.getBean("lazyinitPerson");
//		BeanDefinition
//		XmlBeanDefinitionReader
//		DefaultBeanDefinitionDocumentReader
	}

}
