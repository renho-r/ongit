package com.renho.oauth2authserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.renho.oauth2authserver.mapper")
public class Oauth2AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthServerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
