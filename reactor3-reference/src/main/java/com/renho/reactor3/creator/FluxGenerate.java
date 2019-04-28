package com.renho.reactor3.creator;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

public class FluxGenerate {

    public static void main(String[] args) {

        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                }
        );
        flux.log().subscribe(System.out::println);


        flux = Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) {
                        sink.complete();
                    }
                    return state;
                }, (state) -> System.out.println("state: " + state));
        flux.log().subscribe(System.out::println);
    }
}
