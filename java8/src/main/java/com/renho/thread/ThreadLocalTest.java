package com.renho.thread;

import java.util.concurrent.Executors;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("renho");

        System.out.println(threadLocal.get());

        Executors.newScheduledThreadPool(1);
    }

}
