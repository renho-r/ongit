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
		
<<<<<<< HEAD
		//非ApplicationContext必须显示注册
=======
		//��ApplicationContext������ʾע��
		BeanPostProcessor instantiationAwareBeanPostProcessorImpl = new InstantiationAwareBeanPostProcessorImpl();
		xbf.addBeanPostProcessor(instantiationAwareBeanPostProcessorImpl);
>>>>>>> 4ccc284a86f8313770f03de4d90a746fb9a76e4b
		BeanPostProcessor beanPostProcessor = new BeanPostProcessorImpl();
		xbf.addBeanPostProcessor(beanPostProcessor);
				
		PersonDAO personDAO = (PersonDAO) xbf.getBean("personDAO");
	}

}
