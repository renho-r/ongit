package com.renho.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author renho
 * @date 2021/6/26
 */
public class P46 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> coll = new LinkedList<>();
        backTrace(nums, coll);
        return result;
    }

    private static void backTrace(int[] nums, LinkedList<Integer> coll) {
        if (nums.length == coll.size()) {
            result.add(new LinkedList<>(coll));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!coll.contains(nums[i])) {
                coll.add(nums[i]);
                backTrace(nums, coll);
                coll.removeLast();
            }
        }
    }

}
