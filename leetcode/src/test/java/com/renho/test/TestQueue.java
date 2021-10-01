package com.renho.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author renho
 * @date 2021/6/29
 */
public class TestQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
//        pq.offer(1);
//        pq.offer(2);
//        pq.offer(3);
//        pq.offer(4);
//        pq.offer(5);
//        pq.offer(6);

        pq.offer(6);
        pq.offer(5);
        pq.offer(4);
        pq.offer(3);
        pq.offer(2);
        pq.offer(1);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        pq.peek();

        LinkedList<Integer> ll = new LinkedList<>();
        String x = "";
        ReentrantLock lock = new ReentrantLock();
        Condition f = lock.newCondition();
        lock.unlock();
    }

}
