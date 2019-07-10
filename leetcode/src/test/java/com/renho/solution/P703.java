package com.renho.solution;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P703 {

    @Test
    public void test() {

    }

    class KthLargest {

        private final PriorityQueue<Integer> qk;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            qk = new PriorityQueue<>(k);
            for(int i: nums) {
                add(i);
            }
        }

        public int add(int val) {
            if(qk.size() < this.k) {
                qk.add(val);
            } else if (val > qk.peek()) {
                qk.poll();
                qk.add(val);
            }
            return qk.peek();
        }
    }

}
