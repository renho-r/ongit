package com.renho.hystrix.test.observable;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class ObservableHelloWorld extends HystrixObservableCommand<String> {

    private final String name;

    public ObservableHelloWorld(String name) {
        //必须
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
        System.out.println("new ObservableHelloWorld");
    }

    @Override
    protected Observable<String> construct() {
        System.out.println("ObservableHelloWorld.construct");
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if(!subscriber.isUnsubscribed()) {
                        System.out.println("Observable.OnSubscribe.call");
                        subscriber.onNext("Hello");
                        subscriber.onNext(name + "!");
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    public static void main(String[] ars) throws InterruptedException {

        ObservableHelloWorld hystrixCommand = new ObservableHelloWorld("renho");
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
