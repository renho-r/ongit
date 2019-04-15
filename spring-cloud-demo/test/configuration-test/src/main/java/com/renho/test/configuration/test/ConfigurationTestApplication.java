package com.renho.test.configuration.test;

import com.renho.test.configuration.config.ConfigurationOne;
import com.renho.test.configuration.test.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
public class ConfigurationTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConfigurationTestApplication.class, args);
        ConfigurationOne configurationOne = new ConfigurationOne();
        User user = (User) configurableApplicationContext.getBean("user");
        System.out.println(user);
    }

}
