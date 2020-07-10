package com.renho.test.xmlbeanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.renho.bean.dao.PersonDAO;

@SuppressWarnings("deprecation")
public class TestXmlBeanFactory {

	public static void main(String[] args) {
//		ClassPathResource cpr = new ClassPathResource("springbean/beans.xml");
//		XmlBeanFactory xbf = new XmlBeanFactory(cpr);
//		System.out.println("numbers: " + xbf.getBeanDefinitionCount());
//		System.out.println("containsBean:" + xbf.containsBean("person"));
//		System.out.println("isSingleton:" + xbf.isSingleton("person"));
//		System.out.println("isPrototype:" + xbf.isPrototype("person"));
//		System.out.println("isTypeMatch-Object:" + xbf.isTypeMatch("person", Object.class));
//		System.out.println("isTypeMatch-BeanFactory:" + xbf.isTypeMatch("person", BeanFactory.class));
//		System.out.println("getType:" + xbf.getType("person"));
//		System.out.println("getAliases:" + xbf.getAliases("person").length);
//		System.out.println("renho:" + xbf.getBean("person"));
//		PersonDAO personDAO = (PersonDAO) xbf.getBean("personDAO");
//		String personName = personDAO.getPerson().getPersonName();
//		System.out.println(personName);
		//System.out.println("renho:" + xbf.getBean("personDAO"));
//		DefaultBeanDefinitionDocumentReader
//		AbstractBeanFactory
		
		XmlBeanFactory supXbf = new XmlBeanFactory(new ClassPathResource("springbean/superbeans.xml"));
		XmlBeanFactory xbf = new XmlBeanFactory(new ClassPathResource("springbean/beans.xml"), supXbf);
		System.out.println("numbers: " + xbf.getBeanDefinitionCount());
		System.out.println("containsBean:" + xbf.containsBean("person"));
		System.out.println("isSingleton:" + xbf.isSingleton("person"));
		System.out.println("isPrototype:" + xbf.isPrototype("person"));
		System.out.println("isTypeMatch-Object:" + xbf.isTypeMatch("person", Object.class));
		System.out.println("isTypeMatch-BeanFactory:" + xbf.isTypeMatch("person", BeanFactory.class));
		System.out.println("getType:" + xbf.getType("person"));
		System.out.println("getAliases:" + xbf.getAliases("person").length);
		System.out.println("renho:" + xbf.getBean("person"));
		PersonDAO personDAO = (PersonDAO) xbf.getBean("personDAO");

		PersonDAO perDao = xbf.getBean("personDAO", PersonDAO.class);
	}
}
