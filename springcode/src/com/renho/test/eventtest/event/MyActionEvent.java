package com.renho.test.eventtest.event;

import org.springframework.context.ApplicationEvent;

public class MyActionEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public MyActionEvent(Object source) {
		super(source);
	}
}
