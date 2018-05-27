package com.biaobai.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2Application extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

}