package com.samjin.dp;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(target < -sum || target > sum) return 0;

        int[] dp = new int[2 * sum + 1];

        dp[nums[0] + sum] = 1;
        // [0,0,0,0,0,0,0,0,1]
        dp[-nums[0] + sum] += 1;

        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2 * sum + 1];

            for (int s = 0; s <= 2 * sum; s++) {
                if (dp[s] > 0) {
                    next[s + nums[i]] += dp[s];
                    next[s - nums[i]] += dp[s];
                }
            }

            dp = next;
        }

        return dp[target + sum];
    }
}
