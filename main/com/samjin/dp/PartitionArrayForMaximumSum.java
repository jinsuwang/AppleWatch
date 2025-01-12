package com.samjin.dp;

public class PartitionArrayForMaximumSum {


    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1]; // dp[i] 表示前 i 个元素的最大和

        for (int i = 1; i <= n; i++) {
            int maxValue = 0;

            // 尝试所有长度为 1 到 k 的段
            for (int j = 1; j <= k && i - j >= 0; j++) {
                maxValue = Math.max(maxValue, arr[i - j]); // 找到当前段的最大值
                dp[i] = Math.max(dp[i], dp[i - j] + maxValue * j); // 更新最大和
            }
        }

        return dp[n];
    }
}
