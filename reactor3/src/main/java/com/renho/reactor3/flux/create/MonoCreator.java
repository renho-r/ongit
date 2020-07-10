package com.renho.reactor3.flux.create;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class MonoCreator {

    public static void main(String[] args) {

        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

    }

}
