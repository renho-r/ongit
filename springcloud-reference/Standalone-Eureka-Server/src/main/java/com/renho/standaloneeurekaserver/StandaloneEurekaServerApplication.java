package com.renho.standaloneeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class StandaloneEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StandaloneEurekaServerApplication.class, args);
    }

}
