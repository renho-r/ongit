package com.renho.springbootcode.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor-->postProcessBeanFactory");
        String[] names = beanFactory.getBeanDefinitionNames();
//        Stream.of(names).forEach(System.out::println);
    }
}
