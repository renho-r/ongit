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
		
		//非ApplicationContext必须显示注册
		BeanPostProcessor beanPostProcessor = new BeanPostProcessorImpl();
		xbf.addBeanPostProcessor(beanPostProcessor);
				
		PersonDAO personDAO = (PersonDAO) xbf.getBean("personDAO");
	}

}
