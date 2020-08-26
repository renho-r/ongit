package com.renho.test.beanlifecycle;

import com.renho.bean.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifeCycleConfiguration {

    @Bean
    public Person person() {
        return new Person();
    }

}
