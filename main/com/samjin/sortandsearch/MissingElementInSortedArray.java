package com.samjin.sortandsearch;

public class MissingElementInSortedArray {

    private int missing(int index, int[] nums){
        return nums[index] - nums[0] - index;
    }

    public int missingElement(int[] nums, int k) {

        int n = nums.length;

        // 如果 k 大于 nums[n-1] 前缺失的数字总数
        if (k > missing(n - 1, nums)) {
            // 缺失的第 k 个数字在 nums[n-1] 之后
            return nums[n - 1] + k - missing(n - 1, nums);
        }


        // 二分查找缺失的第 k 个数字
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) /
            if (missing(mid, nums) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left - 1] + k - missing(left - 1, nums);
    }
}
