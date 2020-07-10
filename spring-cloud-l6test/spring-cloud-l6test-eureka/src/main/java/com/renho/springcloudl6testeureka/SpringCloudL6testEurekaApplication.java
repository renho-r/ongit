package com.renho.springcloudl6testeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class SpringCloudL6testEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudL6testEurekaApplication.class, args);
    }

}
