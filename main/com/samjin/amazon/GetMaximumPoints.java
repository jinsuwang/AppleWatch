package com.samjin.amazon;

public class GetMaximumPoints {

    public int getMaxPoints(int[] days, int k) {
        // write your code here

        int n = days.length;

        // Edge case: if k is greater than or equal to total days (not necessary according to the problem statement, but safe-guard)
        if (k >= n) {
            int sum = 0;
            for (int day : days) {
                sum += day;
            }
            return sum;
        }

        // Step 1: Create an extended array to handle cyclic nature
        int[] extendedDays = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extendedDays[i] = days[i % n];
        }

        // Step 2: Use sliding window to find the maximum sum of k consecutive days
        int currentSum = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            currentSum += extendedDays[i];
        }

        int maxSum = currentSum;

        // Slide the window over the extended array
        for (int i = k; i < 2 * n; i++) {
            currentSum += extendedDays[i] - extendedDays[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
