package com.renho.lock.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyLockTest {

    public static void main(String[] args) throws InterruptedException {

        MyLock lock = new MyLock();
        lock.lock();
        System.out.printf("%s: get 1 lock\n", Thread.currentThread().getName());
        new Thread(new Runnable() {
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
        }).start();
        TimeUnit.SECONDS.sleep(3);
        lock.lock();
        System.out.printf("%s: get 2 lock\n", Thread.currentThread().getName());
        lock.unlock();
        System.out.printf("%s: unlock 1 lock\n", Thread.currentThread().getName());
        lock.unlock();
        System.out.printf("%s: unlock 2 lock\n", Thread.currentThread().getName());
    }

}
