package com.renho.reactor3.create;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 既可以是同步， 也可以是异步的，并且还可以每次发出多个元素。
 */
public class FluxCreate {

    public static void main(String[] args) {



        Flux<String> bridge = Flux.create(sink -> {
//            myEventProcessor.register(
//                    new MyEventListener<String>() {
//
//                        @Override
//                        public void onDataChunk(List<String> chunk) {
//                            for(String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        @Override
//                        public void processComplete() {
//                            sink.complete();
//                        }
//                    });
        });
    }
}
