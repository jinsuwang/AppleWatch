package com.samjin.amazon;

import java.util.Arrays;

public class MaximumStability {

    private static final int MOD = 1000000007;

    public int maximumStability(int[] reliability, int[] availability) {
        int n = reliability.length;
        int[][] servers = new int[n][2];

        // Pair up availability and reliability and sort by availability in descending order
        for (int i = 0; i < n; i++) {
            servers[i][0] = availability[i];
            servers[i][1] = reliability[i];
        }

        Arrays.sort(servers, (a, b) -> b[0] - a[0]);

        long maxStability = 0;
        long sumReliability = 0;

        // Iterate through the servers
        for (int i = 0; i < n; i++) {
            int currentAvailability = servers[i][0];
            sumReliability += servers[i][1];
            sumReliability %= MOD; // Keep sumReliability under modulo

            // Calculate current stability
            long currentStability = (currentAvailability * sumReliability) % MOD;
            maxStability = Math.max(maxStability, currentStability);
        }

        return (int) maxStability;
    }

}
