package com.samjin.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1 ? 1 : -1);

            if(sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
