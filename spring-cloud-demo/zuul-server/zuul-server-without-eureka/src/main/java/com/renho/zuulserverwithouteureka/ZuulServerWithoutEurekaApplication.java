package com.renho.zuulserverwithouteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

//@EnableZuulProxy
@EnableZuulServer
@SpringBootApplication
public class ZuulServerWithoutEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerWithoutEurekaApplication.class, args);
    }

}
