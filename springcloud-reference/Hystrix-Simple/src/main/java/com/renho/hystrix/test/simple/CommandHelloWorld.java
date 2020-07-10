package com.renho.hystrix.test.simple;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")); //必须
        this.name = name;
    }

    @Override
    protected String run() {
        /*
         网络调用 或者其他一些业务逻辑，可能会超时或者抛异常
        */
        System.out.println("comman run");
        return "Hello " + name + "!";
    }

    public static void main(String[] ars) throws ExecutionException, InterruptedException {

        //每个Command对象只能调用一次,不可以重复调用,
        //重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.

        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        HystrixCommand<String> hystrixCommand = new CommandHelloWorld("renho");
        String result = hystrixCommand.execute(); //
        System.out.println(result);

        //异步调用,可自由控制获取结果时机
        //get操作不能超过command定义的超时时间,默认:1秒
        hystrixCommand = new CommandHelloWorld("renho");
        Future<String> future = hystrixCommand.queue();
        System.out.println(future.get());
    }
}

