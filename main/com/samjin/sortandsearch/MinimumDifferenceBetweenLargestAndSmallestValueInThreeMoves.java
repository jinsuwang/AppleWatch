package com.samjin.sortandsearch;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        int n = nums.length;
        // 如果数组长度小于等于 4，则无需任何操作，返回 0
        if (n <= 4) {
            return 0;
        }

        // 排序数组
        Arrays.sort(nums);

        // 考虑四种情况
        int option1 = nums[n - 1] - nums[3];  // 去掉最小的 3 个数
        int option2 = nums[n - 2] - nums[2];  // 去掉最小的 2 个数和最大的 1 个数
        int option3 = nums[n - 3] - nums[1];  // 去掉最小的 1 个数和最大的 2 个数
        int option4 = nums[n - 4] - nums[0];  // 去掉最大的 3 个数

        // 取最小的差值
        return Math.min(Math.min(option1, option2), Math.min(option3, option4));
    }
}
