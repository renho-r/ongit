package ainx.common.spring;

import javax.servlet.ServletContextEvent;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.asiainfo.ainx.common.conf.bo.IConfigManager;

public class BeanFactoryListener extends ContextLoaderListener {
	private static BeanFactory factory = null;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		BeanFactoryUtil.initLog4jByListener(event.getServletContext().getRealPath("/"));
		try {
			super.contextInitialized(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		factory = getContextLoader().getCurrentWebApplicationContext();
		
		BeanFactoryUtil.setFactory(factory);
		BeanFactoryUtil.setInited(true);
		
		IConfigManager cm = (IConfigManager) factory.getBean("fileConfigManager");
		cm.setConfig("WEB_APP", event.getServletContext().getRealPath("/"));
		cm.setConfig("server.app.basedir", event.getServletContext().getRealPath("/"));
		cm.setConfig("server.app.contextName", event.getServletContext().getServletContextName());
		cm.initProps(true);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
}
