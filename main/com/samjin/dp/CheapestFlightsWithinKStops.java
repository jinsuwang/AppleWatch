package com.samjin.dp;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][j] represents the minimum cost to get from src to j with at most i stops
        int[][] dp = new int[K + 2][n];  // K + 2 to accommodate stops 0 through K+1
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);  // Initialize all values to infinity
        }
        dp[0][src] = 0;  // Starting point, no cost to start at src

        // Relax edges for K+1 times (from 0 stops to K stops)
        for (int k = 1; k <= K + 1; k++) {
            // Copy the previous row to avoid in-place overwrite issues
            dp[k] = dp[k - 1].clone();
            for (int[] flight : flights) {
                int u = flight[0];  // Source city
                int v = flight[1];  // Destination city
                int price = flight[2];  // Price of the flight

                if (dp[k - 1][u] != Integer.MAX_VALUE) {  // If the source city has a valid cost
                    dp[k][v] = Math.min(dp[k][v], dp[k - 1][u] + price);
                }
            }
        }

        // The answer is in dp[K+1][dst], return -1 if it's still infinity
        return dp[K + 1][dst] == Integer.MAX_VALUE ? -1 : dp[K + 1][dst];
    }
}
