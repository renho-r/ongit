package com.renho.hystrix.test.observable;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class CommandObservableHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandObservableHelloWorld(String name) {
        //必须
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
        System.out.println("CommandObservableHelloWorld");
    }

    @Override
    protected String run() {
        /*
         网络调用 或者其他一些业务逻辑，可能会超时或者抛异常
        */
        System.out.println("comman run");
        return "Hello " + name + "!";
    }

    public static void main(String[] ars) throws InterruptedException {

        CommandObservableHelloWorld hystrixCommand = new CommandObservableHelloWorld("renho");
        Observable<String> observable = hystrixCommand.observe();
        //注意：因为执行是异步的，所以要想看到输出结果这里就要阻塞一下
        Thread.sleep(1000);
        //注册结果回调事件
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String result) {
                System.out.println("observable.Action1.call");
                //执行结果处理,result 为HelloWorldCommand返回的结果
                //用户对结果做二次处理.
            }
        });

//        注册完整执行生命周期事件
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                // onNext/onError完成之后最后回调
                System.out.println("execute onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                // 当产生异常时回调
                System.out.println("onError " + e.getMessage());
                e.printStackTrace();
            }
            @Override
            public void onNext(String v) {
                // 获取结果后回调
                System.out.println("onNext: " + v);
            }
        });
    }

}
