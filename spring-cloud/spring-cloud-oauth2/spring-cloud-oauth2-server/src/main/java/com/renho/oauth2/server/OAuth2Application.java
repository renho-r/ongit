package com.renho.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @auther: renho
 * @since: 1.0.0
 */
@SpringBootApplication
@EnableAuthorizationServer
@ComponentScan(basePackages = {"com.renho"})
public class OAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }
}
