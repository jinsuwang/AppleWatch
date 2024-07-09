package com.samjin.dp;

public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];

        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }

        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
