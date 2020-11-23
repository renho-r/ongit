package com.renho.test.one;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Account {

    public static void main(String[] args) throws InterruptedException {

        Object a = new Object();
        Object b = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(a) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(b) {

                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(b) {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(a) {

                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        AtomicInteger

    }

}
