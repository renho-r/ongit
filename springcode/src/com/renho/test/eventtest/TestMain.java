package com.renho.test.eventtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.renho.test.eventtest.event.ActionLogic;

public class TestMain {

	/**
	 * 
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/springbean/event.xml");
		ActionLogic logic = (ActionLogic) ctx.getBean("actionLogic");
		logic.execute();
	}

}