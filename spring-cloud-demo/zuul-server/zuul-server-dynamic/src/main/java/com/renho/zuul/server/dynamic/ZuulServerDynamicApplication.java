package com.renho.zuul.server.dynamic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServerDynamicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerDynamicApplication.class, args);
    }

}
