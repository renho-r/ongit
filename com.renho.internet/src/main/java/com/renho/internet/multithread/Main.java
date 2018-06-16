package com.renho.internet.multithread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        pool = new ThreadPoolExecutor(1, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(5), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


//        pool = new ThreadPoolExecutor(1, 3,
//                0L, TimeUnit.MILLISECONDS,
//                new SynchronousQueue<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());


        List<Callable<String>> tasks = new ArrayList<>();
        for(int i=0; i<8; i++) {
            Callable task = new MyTask();
            tasks.add(task);
        }
        List<Future<String>> results = pool.invokeAll(tasks);
        results.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return Thread.currentThread().getName();
        }
    }
}
