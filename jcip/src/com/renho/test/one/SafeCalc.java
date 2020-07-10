package com.renho.test.one;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class SafeCalc {

    long value = 0L;

    long get() {
        return value;
    }

    synchronized void addOne() {
        value += 1;
    }

    public static void main(String[] args) throws InterruptedException {

        SafeCalc safeCalc = new SafeCalc();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<20000; i++) {
                    safeCalc.addOne();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<20000; i++) {
                    safeCalc.addOne();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(safeCalc.get());

    }
}
