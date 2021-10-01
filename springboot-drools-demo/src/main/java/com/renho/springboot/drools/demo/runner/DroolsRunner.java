package com.renho.springboot.drools.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author renho
 * @date 2021/3/17
 */
@Component
public class DroolsRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("renho");
    }
}
