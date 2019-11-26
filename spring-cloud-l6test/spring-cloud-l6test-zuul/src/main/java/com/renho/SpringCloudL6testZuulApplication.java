package com.renho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
@ComponentScan(basePackages = {
        "com.renho" })
public class SpringCloudL6testZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudL6testZuulApplication.class, args);
    }

    @Bean
    @RefreshScope
    @Primary
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
