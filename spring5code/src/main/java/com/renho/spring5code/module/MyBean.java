package com.renho.spring5code.module;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Setter
@Slf4j
public class MyBean implements InitializingBean, DisposableBean {

    private String name;

    public MyBean() {
    }

    public MyBean(String name) {
        this.name = name;
    }

    public void init() {
        log.info("MyBean init");
    }

    @Override
    public void destroy() {
        log.info("MyBean destroy");
    }

    @PostConstruct
    public void initJSR250() {
        log.info("MyBean initJSR250");
    }

    @PreDestroy
    public void destroyJSR250() {
        log.info("MyBean destroyJSR250");
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("MyBean afterPropertiesSet");
    }
}
