package com.renho.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class TestLock {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.printf("%s: get 1 lock\n", Thread.currentThread().getName());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("%s: start\n", Thread.currentThread().getName());
                lock.lock();
                try {
                    System.out.printf("%s: get lock\n", Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.printf("%s: unlock lock\n", Thread.currentThread().getName());
            }
        });
        t.setName("other-thread");
        t.start();
        TimeUnit.SECONDS.sleep(3);
        lock.lock();
        System.out.printf("%s: get 2 lock\n", Thread.currentThread().getName());
        lock.unlock();
        System.out.printf("%s: unlock 1 lock\n", Thread.currentThread().getName());
        lock.unlock();
        System.out.printf("%s: unlock 2 lock\n", Thread.currentThread().getName());
    }

}
