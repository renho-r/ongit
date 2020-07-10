package com.renho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableOAuth2Client
@EnableCaching
public class SpringCloudL6testAuthApplication {
    public static void main( String[] args ) {
        SpringApplication.run(SpringCloudL6testAuthApplication.class, args);
    }
}
