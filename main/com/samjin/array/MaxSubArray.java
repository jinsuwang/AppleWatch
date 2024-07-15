package com.samjin.array;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = Integer.MIN_VALUE;

        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];

            sum = Math.max(sum, tmp);

            if (tmp <= 0) tmp = 0;
        }

        return sum;
    }
    // DP solution
    public int maxSubArray2(int[] nums) {

        if (nums.length == 0) return 0;

        int res = nums[0];
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}