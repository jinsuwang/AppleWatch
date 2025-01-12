package com.samjin.array;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsk {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        // 保证0的index是-1
        if (nums[0] != 0){
            map.put(nums[0], 0);
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];

            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i] - k)){
                res = Math.max(res, i - map.get(nums[i] - k));
            }
        }

        return res;
    }
}
