package com.renho.test.beanlifecycle;

import com.renho.bean.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {

    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");

        ApplicationContext context = new ClassPathXmlApplicationContext("springbean/lifecycle.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCycleTest.class.getPackage().getName());
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = context.getBean("person", Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)context).registerShutdownHook();
    }

}
