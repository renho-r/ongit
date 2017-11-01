package com.renho.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author renho
 * @since: 2017/10/13
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("test")) {
            System.out.printf("TestBeanPostProcessor %s postProcessBeforeInitialization\n", beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("test")) {
            System.out.printf("TestBeanPostProcessor %s postProcessAfterInitialization\n", beanName);
        }
        return bean;
    }
}
