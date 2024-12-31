package com.samjin.string;

import java.util.HashSet;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果字符已经在 HashSet 中，则移除（出现偶数次）
            if (charSet.contains(c)) {
                charSet.remove(c);
            } else {
                // 否则将字符加入 HashSet（出现奇数次）
                charSet.add(c);
            }
        }

        // 最多允许有一个字符出现奇数次
        return charSet.size() <= 1;
    }
}
