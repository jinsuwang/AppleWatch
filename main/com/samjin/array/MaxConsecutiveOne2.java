package com.samjin.array;

public class MaxConsecutiveOne2 {


    public int findMaxConsecutiveOnes2(int[] nums) {

        int res = 0;

        int left = 0;
        int right = 0;
        int zeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros == 2) {
                if (nums[left] == 0) {
                    zeros--;
                }

                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;

    }

    public int findMaxConsecutiveOnes3(int[] nums, int k) {
        int max = 0;
        int p0 = -1;
        int start = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                max = Math.max(max, i - start + 1);
            } else {
                if(p0 == -1) p0 = i;

                if(k > 0) {
                    max = Math.max(max, i - start + 1);
                    k--;
                } else {
                    start = p0 + 1;
                    for(int j = p0 + 1; j < nums.length; j++) {
                        if(nums[j] == 0){
                            p0 = j;
                            break;
                        }
                    }
                }
            }
        }

        return max;
    }
}
