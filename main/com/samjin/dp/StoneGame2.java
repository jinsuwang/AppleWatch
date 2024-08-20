package com.samjin.dp;

public class StoneGame2 {

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] sum = new int[n];

        // sum[i] means the sum of stones from piles[i] to the end.
        sum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }

        // Fill dp array
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                // if I take all piles
                if (i + 2 * m >= n) {
                    dp[i][m] = sum[i];
                } else {
                    // else try to minimize the next player's maximum gain
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
}
