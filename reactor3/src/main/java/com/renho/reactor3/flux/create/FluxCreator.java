package com.renho.reactor3.flux.create;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class FluxCreator {

    public static void main(String[] args) throws InterruptedException {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};

        Flux.just(1, 2, 3, 4, 5, "--------------------------").subscribe(System.out::println);

        Flux.fromArray(arr).subscribe(System.out::println);
        System.out.println("------------------------------");

        List<Integer> li = Arrays.asList(arr);
        Flux.fromIterable(li).subscribe(System.out::println);
        System.out.println("------------------------------");

        Flux.fromStream(Stream.of(arr)).subscribe(System.out::println);
        System.out.println("------------------------------");

        Flux.empty().subscribe(System.out::println);
        System.out.println("------------------------------");

//        Flux.error(new Exception("renho exception")).subscribe(System.out::println);
        System.out.println("------------------------------");

        Flux.never().subscribe(System.out::println);
        System.out.println("------------------------------");

        Flux.range(1, 5).subscribe(System.out::println);
        System.out.println("------------------------------");

        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);
        System.out.println("------------------------------");

        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }

}
