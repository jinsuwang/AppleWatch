package com.samjin.array;

public class LongestMountain {

    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // A valid mountain must have at least 3 elements

        int maxLength = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if the current element is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand towards the left of the peak
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand towards the right of the peak
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the mountain
                int currentLength = right - left + 1;
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
