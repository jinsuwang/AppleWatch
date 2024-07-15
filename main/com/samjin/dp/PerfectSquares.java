package com.samjin.dp;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for (int j = 0; j <= i; j++){
                if ( (i - j * j) >= 0 && dp[i - j * j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }

        return dp[n];
    }
}
