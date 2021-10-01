package com.renho.test;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.*;

/**
 * @author renho
 * @date 2021/6/29
 */
public class Tp {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("renho");
                return t;
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }
}
