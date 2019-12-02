package com.renho.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("springbean/factorybean.xml");
        Object obj = ac.getBean("renhoFactoryBean");
        System.out.println(obj);
    }

}
