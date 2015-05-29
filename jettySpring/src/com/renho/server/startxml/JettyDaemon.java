package com.renho.server.startxml;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/*
To embed a Jetty server, the following steps are typical:
   1. Create the server
   2. Add/Configure Connectors
   3. Add/Configure Handlers
   4. Add/Configure Servlets/Webapps to Handlers
   5. start the server
   6. wait (join the server to prevent main exiting). 
*/

public class JettyDaemon implements ApplicationContextAware{

	private Server server;
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}
	
	public void start() throws Exception{
		server = new Server(8080);
		
		WebAppContext webAppContext = new WebAppContext();

		webAppContext.setContextPath("/jettySpring");
		webAppContext.setDescriptor("web/WEB-INF/web.xml");
		webAppContext.setResourceBase("web");
		webAppContext.setConfigurationDiscovered(true);
		webAppContext.setParentLoaderPriority(true);
		server.setHandler(webAppContext);
		
		// ���´����ǹؼ�
		webAppContext.setClassLoader(applicationContext.getClassLoader());
		XmlWebApplicationContext xmlWebAppContext = new XmlWebApplicationContext();
		xmlWebAppContext.setParent(applicationContext);
		xmlWebAppContext.setConfigLocation("");
		xmlWebAppContext.setServletContext(webAppContext.getServletContext());
		xmlWebAppContext.refresh();
		
		webAppContext.setAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
				xmlWebAppContext);

		server.start();
	}

}