package com.renho.spring5code;

import com.renho.spring5code.configuration.MyConfiguration;
import com.renho.spring5code.module.MyBean;
import com.renho.spring5code.service.IMyService;
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
        log.info(String.valueOf(applicationContext.containsBean("com.renho.spring5code.myimport.MyImportBean")));
        log.info(String.valueOf(applicationContext.containsBean("myImportBeanByMyImportBeanDefinitionRegistrar")));

        log.info(applicationContext.getBean("&myFactoryBean").getClass().toString());
        log.info(applicationContext.getBean("myFactoryBean").getClass().toString());

        IMyService myService = (IMyService) applicationContext.getBean("myService");

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
