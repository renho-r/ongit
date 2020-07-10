package com.renho.solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P239 {

    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length==0 || k<=0)  {
            return new int[]{};
        }

        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i=0; i<nums.length; i++) {
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if(i - k >= queue.peekFirst()) {
                queue.pollFirst();
            }
            if(i >= k - 1) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

}
