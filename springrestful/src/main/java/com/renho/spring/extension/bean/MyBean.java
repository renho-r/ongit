package com.renho.spring.extension.bean;

import com.renho.spring.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyBean implements BeanNameAware, BeanFactoryAware, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.logStack();
    }

    @PostConstruct
    public void postConstruct() {
        LogUtil.logStack();
    }

    @Override
    public void setBeanName(String name) {
        LogUtil.logStack();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        LogUtil.logStack();
    }
}
