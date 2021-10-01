package com.renho.solution;

import org.junit.Test;

/**
 * @author renho
 * @date 2021/6/10
 */
public class P1928 {

    @Test
    public void test() {
        int[] test = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(test));
    }

    public int findRepeatNumber(int[] nums) {
        byte[] bitMap = new byte[100000];
        for(int i: nums) {
            if(0 == bitMap[i]) {
                bitMap[i] = 1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
