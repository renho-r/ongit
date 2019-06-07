package com.renho.springcloud.code;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author: renho
 * @since: 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudEurekaApplication.class).web(true).run(args);
    }

}
