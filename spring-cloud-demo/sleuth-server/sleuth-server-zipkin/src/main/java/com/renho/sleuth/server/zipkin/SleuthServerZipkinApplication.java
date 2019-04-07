package com.renho.sleuth.server.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class SleuthServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthServerZipkinApplication.class, args);
    }

}
