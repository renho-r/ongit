package com.renho.springbootcode.beanpostprocessor;

import com.renho.springbootcode.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author renho
 * @date 2020/11/25
 */
//@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        if ("myImportBean".equals(beanName)) {
            LogUtil.mark();
        }
        return beanClass;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        if ("myImportBean".equals(beanName)) {
            LogUtil.mark();
        }
        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if ("myImportBean".equals(beanName)) {
            LogUtil.mark();
        }
        return bean;
    }
}
