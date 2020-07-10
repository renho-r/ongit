package com.renho.reactor3.blockingwrapper;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class BlockingWrapper {

    public static  void main(String[] args) throws InterruptedException {
        Mono blockingWrapper = Mono.fromCallable(() -> {
            /* make a remote synchronous call */
            TimeUnit.SECONDS.sleep(10);
            return "renho";
        });
        blockingWrapper = blockingWrapper.subscribeOn(Schedulers.elastic());

        blockingWrapper.subscribe(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        TimeUnit.SECONDS.sleep(20);
    }

}
