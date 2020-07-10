package com.renho.springwebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello world!");
    }

}
