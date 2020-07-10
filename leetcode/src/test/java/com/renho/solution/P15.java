package com.renho.solution;

import org.junit.Test;

import java.util.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class P15 {

    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> tmpTwoSumMap = new HashMap();
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(tmpTwoSumMap.containsKey(0 - nums[i])) {
                    List<Integer> data = tmpTwoSumMap.get(0 - nums[i]);
                    data.add(nums[i]);
                    result.add(data);
                    tmpTwoSumMap.remove(0 - nums[i]);
                } else {
                    List<Integer> twoSum = new ArrayList<>();
                    twoSum.add(nums[i]);
                    twoSum.add(nums[j]);
                    tmpTwoSumMap.put(nums[i] + nums[j], twoSum);
                }
            }
        }
        return result;

    }

}
