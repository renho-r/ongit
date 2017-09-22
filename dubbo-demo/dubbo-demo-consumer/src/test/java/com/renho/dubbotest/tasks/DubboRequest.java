package com.renho.dubbotest.tasks;

import com.renho.dubbotest.service.ISayHelloService;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.Callable;

/**
 * @author renho
 * @since: 2017/9/22
 */
public class DubboRequest implements Callable<Object> {

    private String id;
    private ISayHelloService sayHelloService;

    public DubboRequest(String id, ISayHelloService sayHelloService) {
        this.id = id;
        this.sayHelloService = sayHelloService;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(sayHelloService.sayHello(Thread.currentThread().getName() + "---------->" + this.id));
        return null;
    }
}
