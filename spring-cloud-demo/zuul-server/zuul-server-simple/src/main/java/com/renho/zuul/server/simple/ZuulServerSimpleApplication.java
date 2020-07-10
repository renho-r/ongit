package com.renho.zuul.server.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServerSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerSimpleApplication.class, args);
    }

}
