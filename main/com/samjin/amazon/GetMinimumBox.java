package com.samjin.amazon;

import java.util.Arrays;

public class GetMinimumBox {

    public int getMinimumBoxes(int[] boxes, int capacity) {
        // write your code here
        Arrays.sort(boxes); // Sort the boxes array

        int n = boxes.length;
        int left = 0;
        int right = 0;
        int maxValidBoxes = 0;

        while (right < n) {
            while (right < n && boxes[right] <= capacity * boxes[left]) {
                right++;
            }
            maxValidBoxes = Math.max(maxValidBoxes, right - left);
            left++;
        }

        return n - maxValidBoxes; // The minimum number of boxes to unload
    }

}