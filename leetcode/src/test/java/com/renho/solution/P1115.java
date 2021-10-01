package com.renho.solution;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author renho
 * @date 2021/6/30
 */
public class P1115 {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);

        Runnable r1 = () -> System.out.print("foo");
        Runnable r2 = () -> System.out.print("bar");
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}

class FooBar {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (!flag) {
                c1.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = false;
            c1.signal();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (flag) {
                c1.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = true;
            c1.signal();
            lock.unlock();
        }
    }
}