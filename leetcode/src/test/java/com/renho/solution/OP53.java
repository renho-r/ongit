package com.renho.solution;

/**
 * @author renho
 * @date 2021/7/16
 */
public class OP53 {

    public static void main(String[] args) {
        OP53 op53 = new OP53();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(op53.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

//    public int search(int[] nums, int target) {
//        if (null == nums || 0 == nums.length) {
//            return 0;
//        }
//        int count = 0;
//        int low = 0;
//        int hight = nums.length - 1;
//        int mid = 0;
//        while(low <= hight) {
//            mid = low + (hight - low) / 2;
//            if (target == nums[mid]) {
//                break;
//            }
//            if (nums[mid] > target) {
//                hight = mid - 1;
//            }
//            if (nums[mid] < target) {
//                low = mid + 1;
//            }
//        }
//        if (low > hight) {
//            return 0;
//        }
//        int index = mid;
//        while (index >= 0 && nums[index] == target) {
//            count++;
//            index--;
//        }
//        index = mid + 1;
//        while (index < nums.length && nums[index] == target) {
//            count++;
//            index++;
//        }
//        return count;
//    }

}
