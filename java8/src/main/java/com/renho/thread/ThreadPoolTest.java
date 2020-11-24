package com.renho.thread;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new LinkedBlockingQueue(1);
        ThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService = new ThreadPoolExecutor(1, 3, 60, TimeUnit.SECONDS, queue, threadFactory, new ThreadPoolExecutor.AbortPolicy());

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.printf("%s\n", "renho");
            }
        });

        List<Callable<String>> tasks = MyTask.getTask(4);
        executorService.invokeAll(tasks);

        executorService.shutdown();

    }

}
