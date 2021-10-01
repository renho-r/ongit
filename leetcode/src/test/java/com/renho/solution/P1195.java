package com.renho.solution;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author renho
 * @date 2021/6/30
 */
public class P1195 {

    public static void main(String[] args) throws InterruptedException {
        Runnable f = () -> System.out.println("fizz");
        Runnable b = () -> System.out.println("buzz");
        Runnable fb = () -> System.out.println("fizzbuzz");
        FizzBuzz fizzBuzz = new FizzBuzz(100);
        Thread ft = new Thread(() -> {
            try {
                fizzBuzz.fizz(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread bt = new Thread(() -> {
            try {
                fizzBuzz.fizz(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread fbt = new Thread(() -> {
            try {
                fizzBuzz.fizz(fb);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread n = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ft.start();
        bt.start();
        fbt.start();
        n.start();

        TimeUnit.SECONDS.sleep(5);


    }
}

class FizzBuzz {
    private int n;
    ReentrantLock lock = new ReentrantLock();
    Condition f = lock.newCondition();
    Condition b = lock.newCondition();
    Condition fb = lock.newCondition();
    volatile boolean print = false;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        printFizz.run();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        printBuzz.run();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        printFizzBuzz.run();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        for(int i=0; i<n; i++) {
            print = false;
            while(!print) {
                if (0==i%3 && 0==i%5) {
                    fb.signal();
                } else if(0 == i%3) {
                    f.signal();
                } else if(0 == i%5) {
                    b.signal();
                } else {
                    printNumber.accept(i);
                    print = true;
                }
                System.out.println(123);
            }
        }
        lock.unlock();
    }
}
