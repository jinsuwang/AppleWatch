package com.samjin.array;

import java.util.Arrays;

public class PythagoreanTriplet {
    public boolean hasPythagoreanTriplet(int[] arr) {
        int n = arr.length;
        // Square all the elements in the array
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Now, we need to find any three numbers a, b, c such that a^2 + b^2 = c^2
        for (int i = n - 1; i >= 2; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] == arr[i]) {
                    return true;
                } else if (arr[left] + arr[right] < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
