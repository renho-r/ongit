package com.renho.test.jcdy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author renho
 * @date 2021/6/30
 */
public class ClientA {

    // 先打印5次“printA…”，再打印5次“printB…”，每次打印间隔1秒，重复循环20次
    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        Thread t1 = new Thread(() -> {
            for (int i=0; i<20; i++) {
                myTask.printA();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i<20; i++) {
                myTask.printB();
            }
        });
//        t1.start();
//        TimeUnit.SECONDS.sleep(5);
        t2.start();
        TimeUnit.SECONDS.sleep(5);
        t1.start();
    }

}

class MyTask {

    private ReentrantLock lock = new ReentrantLock();
    private volatile boolean flag = true;

    public void printA() {
        while (!flag) {

        }
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("printA");
            }
            System.out.println();
            flag = false;
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        while (flag) {

        }
        lock.lock();
        try {
            for (int i=0; i<5; i++) {
                System.out.print("printB");
            }
            System.out.println();
            flag = true;
        } finally {
            lock.unlock();
        }
    }
}
