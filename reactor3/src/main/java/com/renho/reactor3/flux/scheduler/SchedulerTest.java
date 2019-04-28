package com.renho.reactor3.flux.scheduler;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class SchedulerTest {

    public static void main(String[] args) {
        Flux.create(sink -> {
            System.out.println(Thread.currentThread().getName());
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
        .publishOn(Schedulers.single())
        .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
        .publishOn(Schedulers.elastic())
        .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//        .subscribeOn(Schedulers.parallel())
        .toStream()
        .forEach(System.out::println);
    }

}
