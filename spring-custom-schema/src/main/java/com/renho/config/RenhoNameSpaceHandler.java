package com.renho.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class RenhoNameSpaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("application", new RenhoBeanParser());
        registerBeanDefinitionParser("registry", new RenhoBeanParser());
    }
}
