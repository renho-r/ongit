package com.renho.test.eventtest.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationEvent;

import com.renho.bean.pojo.Person;

@SuppressWarnings("rawtypes")
public class ActionListener implements ApplicationListener {

	private List<Person> list = new ArrayList<Person>();
	
	public ActionListener() {
		list.add(new Person("admin", "apass"));
		list.add(new Person("renho", "rpass"));
	}
	
	@SuppressWarnings("unchecked")
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("ActionListener:onApplicationEvent");
		if (event instanceof MyActionEvent) {
			List<Person> gList = (List<Person>) event.getSource();
			for(Person p:gList) {
				System.out.println("name:" + p.getName() + "--password:" + p.getPassword());
			}
			for(Person p:list) {
				System.out.println("name:" + p.getName() + "--password:" + p.getPassword());
			}
		}
	}
}
