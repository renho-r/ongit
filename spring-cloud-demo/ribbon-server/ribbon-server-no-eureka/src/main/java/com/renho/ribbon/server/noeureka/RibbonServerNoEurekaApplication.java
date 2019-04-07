package com.renho.ribbon.server.noeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author renho
 */
@SpringBootApplication
public class RibbonServerNoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServerNoEurekaApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
