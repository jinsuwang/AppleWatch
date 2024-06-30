package com.samjin.array;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {

        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            while( sum >= target ) {
                res = Math.min(res, j - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
