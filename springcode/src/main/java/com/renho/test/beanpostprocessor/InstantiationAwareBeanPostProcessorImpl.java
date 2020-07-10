package com.renho.test.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * @author renho
 * @since: 2020/6/2
 */
public class InstantiationAwareBeanPostProcessorImpl implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>postProcessAfterInitialization");
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("-->postProcessBeforeInstantiation");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("-->postProcessAfterInstantiation");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName) throws BeansException {
        System.out.println("<**postProcessPropertyValues**>");
        return pvs;
    }
}
