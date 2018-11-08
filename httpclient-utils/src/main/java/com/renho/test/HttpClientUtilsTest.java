package com.renho.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class HttpClientUtilsTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(400);
        List<Callable<String>> tasks = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Callable<String> task = new HttpTestTask();
            tasks.add(task);
        }

        executorService.invokeAll(tasks);
    }
}
