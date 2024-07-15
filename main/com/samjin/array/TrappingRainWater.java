package com.samjin.array;

import java.util.Arrays;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int n = height.length;

        int max = left[0] = height[0];
        // left -> right
        for (int i = 1; i < n; i++) {
            if (height[i] < max) left[i] = max;
            else {
                left[i] = height[i];
                max = height[i];
            }
        }

        max = height[n - 1];
        right[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (height[j] < max) right[j] = max;
            else {
                right[j] = height[j];
                max = height[j];
            }
        }

        int volumn = 0;
        for (int k = 1; k < n - 1; k++) {
            int tmp = Math.min(left[k], right[k]) - height[k];
            if (tmp > 0) {
                volumn += tmp;
            }
        }
        return volumn;
    }
}
