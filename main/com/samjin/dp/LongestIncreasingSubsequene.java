package com.samjin.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequene {

    /**
        1. dp数组的含义. dp[i] 以nums[i] 为尾的最长递增子序列的长度。
        2. 递归公式。dp[i] = max(dp[j] + 1, dp[i])
        3. 初始化。 dp[i] = 1;
        4. 遍历顺序。 i, j.
        5. 输出。 记录一个最大值.


     */

    public int lengthOfLIS(int[] nums) {

        int res = 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++){

            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}
