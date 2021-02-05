package com.renho.reactor3.create;

import reactor.core.publisher.Mono;

/**
 * @author renho
 * @date 2021/2/2
 */
public class MonoCreate {

    public static void main(String[] args) {
        Mono<String> mono = Mono.create(sink -> {
            System.out.println(sink);
//            sink.success("hello renho!");
//            sink.error(new RuntimeException("renho"));
//            sink.onCancel(() -> {
//                System.out.println("onCancel");
//            });
        });
        mono.doOnCancel(() -> {
            System.out.println("mono doOnCancel...");
        }).subscribe(System.out::println);
    }
}
