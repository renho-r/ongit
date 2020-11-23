package com.renho.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class FixedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        List<Callable<String>> tasks = getTask(3);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.invokeAll(tasks);

        executorService.shutdown();
    }

    private static List<Callable<String>> getTask(int count) {

        List<Callable<String>> tasks = new ArrayList<>();
        for(int i=0; i<count; i++) {
            tasks.add(new MyTask(i));
        }

        return tasks;
    }
}
