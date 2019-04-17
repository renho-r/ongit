package com.renho.springcloud.reference.custompropertysource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
public class CustomPropertySourceLocatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustomPropertySourceLocatorApplication.class, args);
        System.out.println(context.getEnvironment().getProperty("property.from.sample.custom.source"));
    }

}
