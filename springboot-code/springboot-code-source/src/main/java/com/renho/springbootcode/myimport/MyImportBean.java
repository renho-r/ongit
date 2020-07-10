package com.renho.springbootcode.myimport;

import org.springframework.context.annotation.Bean;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class MyImportBean {

    public MyImportBean() {
        System.out.println("create bean MyImportBean");
    }

    @Bean
    public MyImportBean myBeanImportBean() {
        return new MyImportBean();
    }

}
