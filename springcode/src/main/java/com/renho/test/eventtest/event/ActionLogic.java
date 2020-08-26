package com.renho.test.eventtest.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.renho.bean.pojo.Person;

public class ActionLogic implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public ActionLogic() {
		System.out.println("ActionLogic");
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("setApplicationContext");
	}

	public void execute() {

		List<Person> list = new ArrayList<Person>();
		MyActionEvent event = new MyActionEvent(list);
		this.applicationContext.publishEvent(event);
//		this.applicationContext.
	}
}
