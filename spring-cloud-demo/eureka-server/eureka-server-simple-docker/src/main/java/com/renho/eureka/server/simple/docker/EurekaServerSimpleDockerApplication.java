package com.renho.eureka.server.simple.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author renho
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSimpleDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSimpleDockerApplication.class, args);
    }

}
