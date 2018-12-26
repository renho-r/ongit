package com.renho.spring5code;

import com.renho.spring5code.configuration.MyConfiguration;
import com.renho.spring5code.module.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(MyConfiguration.class);
//        System.out.println(applicationContext.getBean("myBean"));
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(log::info);
        log.info("-------------------------------------->");
        applicationContext.getBeansOfType(MyBean.class).forEach(log::info);
    }
}
