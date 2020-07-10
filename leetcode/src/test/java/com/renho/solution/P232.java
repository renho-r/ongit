package com.renho.solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P232 {

    @Test
    public void test() {

        MyQueue queue = new MyQueue();
        Object obj = queue.pop();
        System.out.println(obj);
    }

    public static class MyQueue{

        Stack<Integer> stack;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return stack.remove(0);
        }

        /** Get the front element. */
        public int peek() {
            return stack.firstElement();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }

    }

}
