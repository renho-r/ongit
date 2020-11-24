package com.renho.dependence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author renho
 * @since: 2020/6/12
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(Test.class.getPackage().getName());
        acac.getBean("singleOneBean");
        acac.getBean("prototypeOneBean");
    }

}
