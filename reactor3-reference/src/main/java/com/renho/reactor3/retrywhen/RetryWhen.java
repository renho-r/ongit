package com.renho.reactor3.retrywhen;

import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class RetryWhen {

    public static void main(String[] args) throws InterruptedException {
//        Flux<String> flux =
//                Flux.<String>error(new IllegalArgumentException())
//                        .retryWhen(companion -> companion
//                                .zipWith(Flux.range(1, 4),
//                                        (error, index) -> {
//                                            if (index < 4) {
//                                                System.out.println("retry: " + index);
//                                                return index;
//                                            } else {
//                                                throw Exceptions.propagate(error);
//                                            }
//                                        })
//                        );
//        flux.log().subscribe(System.out::println);
//        System.out.println("---------------------------->");
//        Flux.<String>error(new IllegalArgumentException())
//                .retry(3)
//                .subscribe(r -> {
//                    System.out.println("subscribe retry: " + r);
//                });
//        myFlux().retry(3).subscribe(System.out::println);
        Flux<String> flux =
                Flux.<String>error(new IllegalArgumentException())
                        .retryWhen(companion -> companion
                                .doOnNext(s -> System.out.println(s + " at " + LocalTime.now()))
                                .zipWith(Flux.range(1, 4), (error, index) -> {
                                    if (index < 4) {
                                        return index;
                                    } else {
                                        throw Exceptions.propagate(error);
                                    }
                                })
                                .flatMap(index -> Mono.delay(Duration.ofMillis(index * 100)))
                                .doOnNext(s -> System.out.println("retried at " + LocalTime.now()))
                        );
        flux.log().subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(200);
    }

    public static Flux<String> myFlux() {
        System.out.println("myFlux");
        return Flux.just("1", "2").concatWith(Flux.error(new Exception("renho exception")));
    }

}
