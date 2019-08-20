package com.renho.config;

import com.renho.bean.Application;
import com.renho.bean.Registry;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class RenhoBeanParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        if ("application".equals(element.getLocalName())) {
            BeanDefinition applicationBeanDefinition = new RootBeanDefinition();
            applicationBeanDefinition.setBeanClassName(Application.class.getName());
            parserContext.getRegistry().registerBeanDefinition("application", applicationBeanDefinition);
            return applicationBeanDefinition;
        }
        if ("registry".equals(element.getLocalName())) {
            BeanDefinition registryBeanDefinition = new RootBeanDefinition();
            registryBeanDefinition.setBeanClassName(Registry.class.getName());
            parserContext.getRegistry().registerBeanDefinition("registry", registryBeanDefinition);
            return registryBeanDefinition;
        }
        return null;
    }

}
