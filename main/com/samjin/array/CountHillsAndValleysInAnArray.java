package com.samjin.array;

public class CountHillsAndValleysInAnArray {

    public int countHillValley(int[] nums) {
        int count = 0;
        int prev = nums[0]; // 记录前一个有效值

        for (int i = 1; i < nums.length - 1; i++) {
            // 跳过连续相同的值
            if (nums[i] == nums[i + 1]) continue;

            // 判断山峰或山谷
            if ((prev < nums[i] && nums[i] > nums[i + 1]) ||
                    (prev > nums[i] && nums[i] < nums[i + 1])) {
                count++;
            }

            // 更新前一个有效值
            prev = nums[i];
        }

        return count;
    }
}
