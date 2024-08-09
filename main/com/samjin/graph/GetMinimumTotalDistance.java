package com.samjin.graph;

import java.util.Arrays;

public class GetMinimumTotalDistance {

    public static int getMinTotalDistance(int[] dist_centers) {
        int n = dist_centers.length;
        Arrays.sort(dist_centers); // Sort the distribution centers

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Calculate minimum sum of distances for one warehouse
        for (int i = 0; i < n; i++) {
            dp[i] = sumOfDistances(dist_centers, 0, i);
        }

        int minTotalDistance = Integer.MAX_VALUE;

        // Try all possible splits for the second warehouse
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumDist = dp[i] + sumOfDistances(dist_centers, i + 1, j);
                minTotalDistance = Math.min(minTotalDistance, sumDist);
            }
        }

        return minTotalDistance;
    }

    private static int sumOfDistances(int[] dist_centers, int start, int end) {
        int n = end - start + 1;
        int median = dist_centers[start + n / 2];
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += Math.abs(dist_centers[i] - median);
        }
        return sum;
    }
}
