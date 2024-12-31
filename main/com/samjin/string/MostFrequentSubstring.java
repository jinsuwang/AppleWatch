package com.samjin.string;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubstring {
    public static String findMostFrequentSubstring(String s, int k) {
        // 处理边界情况
        if (s == null || s.length() == 0 || k > s.length()) {
            return "";
        }

        // 使用哈希表来统计每个子串的出现次数
        Map<String, Integer> substringCount = new HashMap<>();

        // 遍历所有长度为 k 的子串
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
        }

        // 找到出现次数最多的子串
        String mostFrequentSubstring = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentSubstring = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentSubstring;
    }
}
