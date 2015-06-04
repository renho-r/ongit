package com.renho.init;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

public class BeanFactoryUtil extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
	
}
