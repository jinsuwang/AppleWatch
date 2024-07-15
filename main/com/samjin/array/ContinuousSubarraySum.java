package com.samjin.array;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = nums[0] % k;

        map.put(sum, 0);


        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];
            sum = (sum + num) % k;

            if (sum == 0) return true;
            if (map.containsKey(sum) && i - map.get(sum) > 1) return true;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return false;
    }
}