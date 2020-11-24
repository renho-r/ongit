package com.renho.lock.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.printf("%s\n", "");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.setName("other-thread");
        t.start();

        System.out.printf("%s\n", "");
        semaphore.release();
    }

}
