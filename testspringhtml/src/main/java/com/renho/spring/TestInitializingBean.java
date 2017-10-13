package com.renho.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author renho
 * @since: 2017/10/13
 */
@Component
public class TestInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("TestInitializingBean afterPropertiesSet\n");
    }

    @PostConstruct
    public void testPostConstract() {
        System.out.println("TestInitializingBean testPostConstruct");
    }
}
