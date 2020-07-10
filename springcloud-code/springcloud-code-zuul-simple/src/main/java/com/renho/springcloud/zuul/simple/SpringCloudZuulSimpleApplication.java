package com.renho.springcloud.zuul.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudZuulSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulSimpleApplication.class);
    }

}
