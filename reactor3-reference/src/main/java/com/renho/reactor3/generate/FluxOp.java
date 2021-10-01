package com.renho.reactor3.generate;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renho
 * @date 2021/5/10
 */
public class FluxOp {

    public static void main(String[] args) {
        List<String> datas = new ArrayList<>();
        datas.add("r");
        datas.add("e");
        datas.add("n");
        datas.add("h");
        datas.add("o");

        Flux.fromStream(datas.stream())
                .doOnNext(s -> System.out.println("doOnNext: " + s))
                .doOnNext(s -> {
//                    if("n".equals(s)) {
//                        throw new Exception("renho");
//                    }
                })
                .doOnRequest(s -> System.out.println("doOnRequest: " + s))
                .subscribe();
        System.out.println("-----------------><-------------------------");
//        Flux.fromStream(datas.stream()).doOnEach(s -> System.out.println("info1: " + s.getType())).doOnComplete(() -> System.out.println("完成")).subscribe();
    }

}
