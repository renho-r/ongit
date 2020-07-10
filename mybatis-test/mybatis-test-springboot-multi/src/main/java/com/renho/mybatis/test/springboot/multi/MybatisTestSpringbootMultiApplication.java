package com.renho.mybatis.test.springboot.multi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author renho
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.renho.mybatis.test.springboot.multi.mapper")
public class MybatisTestSpringbootMultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisTestSpringbootMultiApplication.class, args);
    }

}
