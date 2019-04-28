package com.renho.reactor3.flux.test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

import java.time.Duration;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ReactorTest {

    public static void main(String[] args) {
        StepVerifier.create(Flux.just("a", "b"))
                .expectNext("a")
                .expectNext("b")
                .verifyComplete();

        StepVerifier.withVirtualTime(() -> Flux.interval(Duration.ofHours(4), Duration.ofDays(1)).take(2))
                .expectSubscription()
                .expectNoEvent(Duration.ofHours(4))
                .expectNext(0L)
                .thenAwait(Duration.ofDays(1))
                .expectNext(1L)
                .verifyComplete();

        final TestPublisher<String> testPublisher = TestPublisher.create();
        testPublisher.next("a");
        testPublisher.next("b");
        testPublisher.complete();

        StepVerifier.create(testPublisher)
                .expectNext("a")
                .expectNext("b")
                .expectComplete();
    }

}
