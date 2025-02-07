package com.samjin.dp;

public class MaximumProfitFromTradingStocks {

    public int maxProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int cost = present[i];
            int profit = Math.max(0, future[i] - present[i]); // Only consider profitable stocks

            // Iterate backwards to avoid overwriting previous values
            for (int j = budget; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + profit);
            }
        }

        return dp[budget];
    }
}
