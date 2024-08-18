package com.samjin.array;

public class MinimumAdjacentSwapToMakeAValidArray {

    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] < nums[minIndex] || (nums[i] == nums[minIndex] && i < minIndex)) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex] || (nums[i] == nums[maxIndex] && i > maxIndex)) {
                maxIndex = i;
            }
        }

        if (minIndex == maxIndex) {
            return 0;
        }
        return minIndex + (n - 1 - maxIndex) - (minIndex > maxIndex ? 1 : 0);
    }
}
