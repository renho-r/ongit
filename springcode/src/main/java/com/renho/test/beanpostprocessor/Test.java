package com.renho.test.beanpostprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.renho.bean.dao.PersonDAO;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		XmlBeanFactory supXbf = new XmlBeanFactory(new ClassPathResource("springbean/superbeans.xml"));
		XmlBeanFactory xbf = new XmlBeanFactory(new ClassPathResource("springbean/beans.xml"), supXbf);
		
		//·ÇApplicationContext±ØÐëÏÔÊ¾×¢²á
		BeanPostProcessor instantiationAwareBeanPostProcessorImpl = new InstantiationAwareBeanPostProcessorImpl();
		xbf.addBeanPostProcessor(instantiationAwareBeanPostProcessorImpl);
		BeanPostProcessor beanPostProcessor = new BeanPostProcessorImpl();
		xbf.addBeanPostProcessor(beanPostProcessor);
				
		PersonDAO personDAO = (PersonDAO) xbf.getBean("personDAO");
		String personName = personDAO.getPerson().getPersonName();
		System.out.println(personName);
		
		PersonDAO perDao = xbf.getBean("personDAO", PersonDAO.class);
		System.out.println(perDao.getPerson().getPersonName());
	}

}
