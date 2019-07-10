package com.renho;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class CircularReference {

    @Test
    public void CircularReferenceTest() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("circularreference.xml");
        System.out.println(applicationContext.getBean("compositeA"));
        System.out.println(applicationContext.getBean("compositeA"));
        System.out.println(applicationContext.getBean("compositeA"));
        System.out.println(applicationContext.getBean("compositeA"));
    }

}
