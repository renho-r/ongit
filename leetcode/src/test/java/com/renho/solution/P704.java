package com.renho.solution;

import org.junit.Test;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P704 {

    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            System.out.println(left + ":" + mid + ":" + right);
            if (nums[mid] == target) {
               return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
