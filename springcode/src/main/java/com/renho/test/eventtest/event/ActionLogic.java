package com.renho.test.eventtest.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.renho.bean.pojo.Person;

public class ActionLogic implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void execute() {

		List<Person> list = new ArrayList<Person>();
		list.add(new Person("admin", "apass0"));
		list.add(new Person("renho", "rpass0"));
		MyActionEvent event = new MyActionEvent(list);
		this.applicationContext.publishEvent(event);
//		this.applicationContext.
	}
}