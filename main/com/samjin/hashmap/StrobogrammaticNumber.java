package com.samjin.hashmap;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        // 定义中心对称的映射
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        // 双指针
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            // 检查是否是有效的中心对称字符对
            if (!map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
