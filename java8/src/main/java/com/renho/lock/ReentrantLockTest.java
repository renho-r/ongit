package com.renho.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author renho
 * @since: 2019/10/31
 */
public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(true);
        lock.lock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.printf("%s: lock", Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        t.setName("other-thread");
        t.start();
        TimeUnit.SECONDS.sleep(3);
        lock.unlock();
    }
}