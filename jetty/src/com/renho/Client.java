package com.renho;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Client {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);  
        // ����һ���Ѿ����ڵ�������  
        WebAppContext context = new WebAppContext();  
        // ����������λ��  
        context.setDescriptor("./web/WEB-INF/web.xml");  
        // ����Web����������·��  
        context.setResourceBase("./web");  
        // ����������·��  
        context.setContextPath("/jetty");  
        context.setParentLoaderPriority(true);  
        server.setHandler(context);
        // ����  
        server.start();  
        server.join();  
	}

}
