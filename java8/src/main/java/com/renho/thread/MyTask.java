package com.renho.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyTask implements Callable<String> {

    private Integer id;

    MyTask(Integer id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("id[ %s ] call ...\n", id);
        TimeUnit.SECONDS.sleep(1);
        return UUID.randomUUID().toString();
    }

    public static List<Callable<String>> getTask(int count) {

        List<Callable<String>> tasks = new ArrayList<>();
        for(int i=0; i<count; i++) {
            tasks.add(new MyTask(i));
        }

        return tasks;
    }
}
