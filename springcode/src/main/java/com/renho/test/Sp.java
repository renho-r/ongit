package com.renho.test;

import com.renho.bean.pojo.Prototype;
import com.renho.bean.pojo.Singleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Sp {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextFor.xml");

        ac.getBean("singletonA");
        ac.getBean("prototypeA");

//        Prototype prototype = (Prototype) ac.getBean("prototype");
//
//
//        System.out.println(singleton);
//        System.out.println(prototype);
    }

}
