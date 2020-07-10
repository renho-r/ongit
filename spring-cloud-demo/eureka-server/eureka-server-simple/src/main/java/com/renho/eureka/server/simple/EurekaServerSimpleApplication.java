package com.renho.eureka.server.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author renho
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSimpleApplication.class, args);
    }

}
