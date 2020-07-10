package com.renho.zk.client;

import org.junit.Test;

import java.util.LinkedList;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class LinkedListQueue {

    private LinkedList queue = new LinkedList();

    public void makeData(IntConsumer function) {
        for(int i=0; i<10; i++) {
            function.accept(i);
        }
    }

    public void eachData(Supplier<Integer> supplier) {
        while (queue.size() > 0) {
            System.out.printf("%s,", supplier.get());
        }
        System.out.printf("\n");
    }

    @Test
    public void testLinkedList() {

        makeData(new AddConsumer());
        eachData(new RemoveSupplier());
        System.out.printf("size: %s\n", queue.size());

        makeData(new AddConsumer());
        eachData(new PopSupplier());
        System.out.printf("size: %s\n", queue.size());

        makeData(new PushConsumer());
        eachData(new PopSupplier());
        System.out.printf("size: %s\n", queue.size());
    }

    class AddConsumer implements IntConsumer {

        @Override
        public void accept(int value) {
            queue.add(value);
        }
    }

    class PushConsumer implements IntConsumer {

        @Override
        public void accept(int value) {
            queue.push(value);
        }
    }

    class PopSupplier implements Supplier {

        @Override
        public Object get() {
            return queue.pop();
        }
    }

    class RemoveSupplier implements Supplier {

        @Override
        public Object get() {
            return queue.remove();
        }
    }
}
