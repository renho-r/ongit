package com.renho.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P122 {

    @Test
    public void test() {
//        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
//        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums = new  int[]{7, 6, 4, 3, 1};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i=0; i<prices.length-1; i++) {
            int thisPrice = prices[i];
            int nextPrice = prices[i+1];
            if(nextPrice - thisPrice > 0) {
                result += (nextPrice - thisPrice);
            } else {
                //nothing
            }
        }
        return result;
    }

}
