package com.renho.springcloud.gateway.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringcloudGatewayOpenApplication {
    public static void main( String[] args ) {
        SpringApplication.run(SpringcloudGatewayOpenApplication.class, args);
    }
}
