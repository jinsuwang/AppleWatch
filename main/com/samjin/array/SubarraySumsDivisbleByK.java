package com.samjin.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisbleByK {

    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> prefixMap = new HashMap<>();

        prefixMap.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int reminder = sum % k;

            if (reminder < 0) reminder += k;

            if (prefixMap.containsKey((reminder))){
                count += prefixMap.get(reminder);
            }

            prefixMap.put(reminder, prefixMap.getOrDefault(reminder, 0) + 1);
        }

        return count;
    }
}
