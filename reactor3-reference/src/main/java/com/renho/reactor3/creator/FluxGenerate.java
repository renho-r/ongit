package com.renho.reactor3.creator;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

public class FluxGenerate {

    public static void main(String[] args) {

//        Flux<String> flux = Flux.generate(
//                () -> 0,
//                (state, sink) -> {
//                    sink.next("3 x " + state + " = " + 3 * state);
//                    if (state == 10) {
//                        sink.complete();
//                    }
//                    return state + 1;
//                }
//        );
//        flux.log().subscribe(System.out::println);
//
//
//        flux = Flux.generate(
//                AtomicLong::new,
//                (state, sink) -> {
//                    long i = state.getAndIncrement();
//                    sink.next("3 x " + i + " = " + 3*i);
//                    if (i == 10) {
//                        sink.complete();
//                    }
//                    return state;
//                }, (state) -> System.out.println("state: " + state));
//        flux.log().subscribe(System.out::println);


//        Flux.range(1, 6).log()
//                .map(i -> {
//                    System.out.println("1 map");
//                    return i;
////                    return 10/(i-3);
//                })
//                .onErrorReturn(0)   // 1
//                .map(i -> {
//                    System.out.println("2 map");
//                    return i*i;
//                })
//                .subscribe(System.out::println, System.err::println);

        Stream.of(1, 2, 3, 4, 5)
                .map(i -> {
                    System.out.println("1 map");
                    return i;
                })
                .map(i -> {
                    System.out.println("2 map");
                    return i*i;
                })
                .filter(i -> {
                    System.out.println("3 filter");
                    return true;
                })
//                .collect(Collectors.toList())
                .forEach(i -> {
                    System.out.println("4 foreach");
                });

    }
}
