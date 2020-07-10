package com.renho.reactor3;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class FluxTest {

    public static void main(String[] args) throws InterruptedException {
        Flux.just("1", "A", 3).subscribe(System.out::println);

        Flux.interval(Duration.of(500, ChronoUnit.MILLIS)).subscribe(System.out::println);

        //防止程序过早退出，放一个CountDownLatch拦住
//        CountDownLatch latch = new CountDownLatch(1);
//        latch.await();

        Flux.empty().subscribe(System.out::println);

        Flux.generate(i -> {
            i.next("AAAAA");
            //i.next("BBBBB");//注意generate中next只能调用1次
            i.complete();
        }).subscribe(System.out::println);

        final Random rnd = new Random();
        Flux.generate(ArrayList::new, (list, item) -> {
            Integer value = rnd.nextInt(100);
            list.add(value);
            item.next(value);
            if (list.size() >= 10) {
                item.complete();
            }
            return list;
        }).subscribe(System.out::println);

        Flux.generate(FluxTest::new, (a, b) -> {
            System.out.println(a);
            b.complete();
            return a;
        }).subscribe(System.out::println);
    }

}
