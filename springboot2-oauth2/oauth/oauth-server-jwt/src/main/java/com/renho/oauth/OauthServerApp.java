package com.renho.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
@MapperScan("com.renho.oauth.mapper")
public class OauthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApp.class, args);
    }

}
