package com.renho.mybatis.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MybatisTestSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTestSpringbootApplication.class, args);
    }

}
