package com.renho.test.one;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class FutureTaskTest {

    public static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            String name = "renho-" + UUID.randomUUID().toString();
            System.out.println("create thread: " + name);
            Thread thread = new Thread(r);
            thread.setName(name);
            return thread;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() {
                try {

                    System.out.println("callable call ...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "renho";
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                return "renho";
            }
        });
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    System.out.println("callable call ...");
                    TimeUnit.SECONDS.sleep(1);
                    return "renho";
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                return "renho";
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2), new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future future = executor.submit(futureTask);
        System.out.println("before get: " + System.currentTimeMillis());
        Object result = future.get(//        System.out.println("after get: " + System.currentTimeMillis() + " : " + result.toString());
        );
        System.out.println("after get: " + System.currentTimeMillis() + " : " + futureTask.get().toString());
        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
    }

}
