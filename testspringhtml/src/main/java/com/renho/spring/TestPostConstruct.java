package com.renho.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author renho
 * @since: 2017/10/13
 */
@Component
public class TestPostConstruct {

    @PostConstruct
    public void testPostConstruct() {
        System.out.println("TestPostConstruct testPostConstruct");
    }

}
