package com.renho.feign.server.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author renho
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignServerSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignServerSimpleApplication.class, args);
    }

}
