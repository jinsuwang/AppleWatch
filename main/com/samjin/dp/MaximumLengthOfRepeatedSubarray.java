package com.samjin.dp;

public class MaximumLengthOfRepeatedSubarray {
    /**
     *  1. dp[i][j]. 以i,j 为结尾的最长重复子数组。
     *  2. dp[i][j] = dp[i-1][j-1] when nums1[i] == nums2[j].
     *  3.
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        int res = 0;

        for (int i = 1; i <= nums1.length; i++ ){
            for (int j = 1; j<= nums2.length; j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;

    }
}
