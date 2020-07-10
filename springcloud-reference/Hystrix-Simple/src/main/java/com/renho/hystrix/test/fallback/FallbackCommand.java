package com.renho.hystrix.test.fallback;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class FallbackCommand extends HystrixCommand<String> {

    private final String name;

    public FallbackCommand(String name) {
        //必须
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
        System.out.println("new FallbackCommand");
    }

    @Override
    protected String run() throws Exception {
        System.out.println("FallbackCommand.run");
        System.out.println(1/0);
        return "renho";
    }

    @Override
    protected String getFallback() {
        return "exeucute getFallback";
    }

    public static void main(String[] ars) throws InterruptedException {
        HystrixCommand<String> command = new FallbackCommand("renho-name");
        String result = command.execute();
        System.out.println("result: " + result);
    }
}
