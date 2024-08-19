package com.samjin.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousArray {

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 初始化前缀和为0的位置为-1，处理从数组开始的子数组

        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // 将0视为-1
            prefixSum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(prefixSum)) {
                // 如果前缀和之前出现过，则计算这个子数组的长度
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // 如果前缀和第一次出现，记录这个位置
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
