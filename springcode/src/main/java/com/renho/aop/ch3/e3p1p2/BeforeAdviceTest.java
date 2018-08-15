package com.renho.aop.ch3.e3p1p2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeforeAdviceTest {

	private DefaultListableBeanFactory dlbf;
	
	@Before
	public void setUp() throws Exception {
		ClassPathResource cpr = new ClassPathResource("springbean/applicationContext-beforeAdvice.xml");
		dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(cpr);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		MyXXXService myXXXService = (MyXXXService) dlbf.getBean("aopService");
		myXXXService.add();
		CountingBeforeAdvice countingBeforeAdvice = (CountingBeforeAdvice) dlbf.getBean("countingBeforeAdvice");
		System.out.println(countingBeforeAdvice.getCount());
		
		myXXXService.query(100);
		System.out.println(countingBeforeAdvice.getCount());
	}

}
