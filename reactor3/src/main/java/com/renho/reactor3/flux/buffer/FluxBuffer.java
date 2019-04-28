package com.renho.reactor3.flux.buffer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class FluxBuffer {

    public static void main(String[] args) {

        Flux.range(1, 100).buffer(20).subscribe(System.out::println);

        Flux.interval(Duration.of(100, ChronoUnit.MILLIS))//100毫秒生成1个
                .bufferTimeout(100, Duration.of(1000, ChronoUnit.MILLIS))//1000毫秒内最大缓存100个
                .take(3)//只取前3个
                .toStream()
                .forEach(System.out::println);
        Flux.range(1, 10).bufferUntil(i -> i % 2 == 0).subscribe(System.out::println);
        Flux.range(1, 10).bufferWhile(i -> i % 2 == 0).subscribe(System.out::println);

        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

        Flux.range(1, 100).window(20).subscribe(System.out::println);
        Flux.interval(Duration.of(100, ChronoUnit.MILLIS)).windowTimeout(10, Duration.of(10, ChronoUnit.MILLIS)).take(2).toStream().forEach(System.out::println);

        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);

        Flux.range(1, 1000).take(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
        Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
        Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

        Flux.range(1, 100).reduce((x, y) -> x + y).subscribe(System.out::println);
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);

        Flux.merge(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
                .toStream()
                .forEach(System.out::println);
        Flux.mergeSequential(Flux.interval(Duration.ofMillis(100)).take(5), Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(5))
                .toStream()
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        Flux.interval(Duration.ofMillis(5 * 10), Duration.ofMillis(100)).take(5).toStream().forEach(System.out::println);
//        Flux.just(5, 10)
//                .flatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
//                .toStream()
//                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        Flux.just(5, 10)
                .concatMap(x -> Flux.interval(Duration.ofMillis(x * 10), Duration.ofMillis(100)).take(x))
                .toStream()
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .subscribe(System.out::println, System.err::println);
        System.out.println("-----------------------------------------------------");
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .onErrorReturn(0)
                .subscribe(System.out::println);
        System.out.println("-----------------------------------------------------");

        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .retry(1)
                .subscribe(System.out::println);
    }

}
