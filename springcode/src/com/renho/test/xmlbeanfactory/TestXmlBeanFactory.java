package com.renho.test.xmlbeanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class TestXmlBeanFactory {

	public static void main(String[] args) {
		ClassPathResource cpr = new ClassPathResource("springbean/beans.xml");
		XmlBeanFactory xbf = new XmlBeanFactory(cpr);
		System.out.println("numbers: " + xbf.getBeanDefinitionCount());
		System.out.println("containsBean:" + xbf.containsBean("person"));
		System.out.println("isSingleton:" + xbf.isSingleton("person"));
		System.out.println("isPrototype:" + xbf.isPrototype("person"));
		System.out.println("isTypeMatch-Object:" + xbf.isTypeMatch("person", Object.class));
		System.out.println("isTypeMatch-BeanFactory:" + xbf.isTypeMatch("person", BeanFactory.class));
		System.out.println("getType:" + xbf.getType("person"));
		System.out.println("getAliases:" + xbf.getAliases("person").length);
		System.out.println("renho:" + xbf.getBean("person"));
	}
}
