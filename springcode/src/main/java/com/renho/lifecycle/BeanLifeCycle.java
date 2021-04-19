package com.renho.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");

        ApplicationContext factory = new ClassPathXmlApplicationContext("springbean/lifecycle.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);
        System.out.printf("%s\n", person.getClass().getName());
//        ((ClassPathXmlApplicationContext)factory).start();
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
