package com.renho.springbootcode.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
public class MyRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyRunner: run");
    }
}
