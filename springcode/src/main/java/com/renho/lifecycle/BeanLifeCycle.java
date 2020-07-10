package com.renho.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class BeanLifeCycle {

    public static void main(String[] args) {

        System.out.println("���ڿ�ʼ��ʼ������");

        ApplicationContext factory = new ClassPathXmlApplicationContext("springbean/lifecycle.xml");
        System.out.println("������ʼ���ɹ�");
        //�õ�Preson����ʹ��
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);
        System.out.printf("%s\n", person.getClass().getName());

        System.out.println("���ڿ�ʼ�ر�������");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
