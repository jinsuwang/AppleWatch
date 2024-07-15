package com.samjin.sortandsearch;

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
        double target = Math.random() * sum[sum.length - 1];

        int left = 0;
        int right = sum.length - 1;

        while(left + 1 < right) {
            int mid = (left + right) / 2;

            if(sum[mid] == target) return mid;

            if(sum[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if(sum[left] >= target) {
            return left;
        } else {
            return right;
        }
    }
}
