package com.samjin.array;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length <= 1) return nums.length;

        int currDiff = 0;
        int prevDiff = 0;

        int count = 1;

        for (int i = 1; i < nums.length; i++){

            currDiff = nums[i] - nums[i-1];
            if ((currDiff > 0 && prevDiff <=0 ) || currDiff < 0 && prevDiff >= 0){
                count++;
                prevDiff = currDiff;
            }
        }

        return count;
    }
}