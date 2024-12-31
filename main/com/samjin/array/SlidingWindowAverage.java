package com.samjin.array;

public class SlidingWindowAverage {

    public double[] findMaxAverage(int[] nums, int k) {
        // Check for invalid inputs
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new double[0];
        }

        int n = nums.length;
        double[] result = new double[n - k + 1];
        double windowSum = 0;

        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // Set the first average value
        result[0] = windowSum / k;

        // Slide the window and calculate the moving average
        for (int i = k; i < n; i++) {
            // Slide the window by removing the first element of the window and adding the new element
            windowSum = windowSum - nums[i - k] + nums[i];
            result[i - k + 1] = windowSum / k;
        }

        return result;
    }

}
