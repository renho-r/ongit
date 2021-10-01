package com.renho;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author renho
 * @date 2021/9/5
 */
public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

    }
}
