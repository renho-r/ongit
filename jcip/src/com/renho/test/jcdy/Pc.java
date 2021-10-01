package com.renho.test.jcdy;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author renho
 * @date 2021/6/30
 */
public class Pc {
    public static void main(String[] args) {
        Box box = new Box(10);
        for(int i=0; i<10; i++) {
            Thread c = new Thread(new Consumer(box));
            c.setName("Consumer-" + i);
            c.start();
            Thread p = new Thread(new Producer(box));
            p.setName("Producer-" + i);
            p.start();
        }
    }
}

class Box {

    private int size = 0;
    private int max;
    private BlockingQueue<String> queue;
//    private ReentrantLock lock = new ReentrantLock();

    public Box(int max) {
        this.max = max;
        this.queue = new ArrayBlockingQueue(max);
    }

    public synchronized void add(String name) {
        while (size >= max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(name);
        size++;
        notifyAll();
    }

    public synchronized String remove() {
        while (0 == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String name = queue.remove();
        size--;
        notifyAll();
        return name;
    }

}

class Producer implements Runnable {

    private Box box;

    public Producer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for(int i=0; ; i++) {
            String name = Thread.currentThread().getName() + "-" + i;
            box.add(name);
            System.out.println("producer: " + name);
        }
    }
}

class Consumer implements Runnable {

    private Box box;

    public Consumer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for(int i=0; ; i++) {
            System.out.println("consumer: " + box.remove());
        }
    }
}

