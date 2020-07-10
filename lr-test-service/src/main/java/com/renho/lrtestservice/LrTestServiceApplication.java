package com.renho.lrtestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LrTestServiceApplication extends SpringBootServletInitializer {

    //重写配置方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LrTestServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LrTestServiceApplication.class, args);
    }

}
