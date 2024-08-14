package com.samjin.sortandsearch;

import java.util.Random;

public class RandomPickWithWeight {
    int[] sum;

    public RandomPickWithWeight(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int target =  rand.nextInt(sum[sum.length-1]) + 1; // Random number between 1 and totalSum

        int left = 0;
        int right = sum.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(sum[mid] == target) return mid;

            if(sum[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
