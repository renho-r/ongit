package com.renho.springbootcode.myimport;

import com.renho.springbootcode.util.LogUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class MyImportBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware, EmbeddedValueResolverAware, ApplicationContextAware, InitializingBean, ResourceLoaderAware {

    public MyImportBean() {
        System.out.println("create bean MyImportBean");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name + "-------------------------------------------------》");
        LogUtil.mark();
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        LogUtil.mark();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        LogUtil.mark();
    }

    @Override
    public void setEnvironment(Environment environment) {
        LogUtil.mark();
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        LogUtil.mark();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LogUtil.mark();
    }

    @PostConstruct
    public void init() {
        LogUtil.mark();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.mark();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        LogUtil.mark();
    }
}
