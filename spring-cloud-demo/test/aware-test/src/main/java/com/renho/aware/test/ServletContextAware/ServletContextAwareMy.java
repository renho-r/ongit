package com.renho.aware.test.ServletContextAware;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class ServletContextAwareMy implements ServletContextAware {

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("ServletContextAwareMy");
    }
}
