package com.samjin.string;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        // 创建一个哈希表，记录每个字母在外星字母表中的顺序
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        // 比较相邻的单词
        for (int i = 0; i < words.length - 1; i++) {
            if (!inCorrectOrder(words[i], words[i + 1], orderMap)) {
                return false;  // 如果发现某一对单词顺序不对，直接返回 false
            }
        }

        return true;  // 所有单词都符合顺序
    }

    private boolean inCorrectOrder(String word1, String word2, int[] orderMap) {
        int len1 = word1.length();
        int len2 = word2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);

            if (char1 != char2) {
                // 比较两个字符在外星字母表中的顺序
                return orderMap[char1 - 'a'] < orderMap[char2 - 'a'];
            }
        }

        // 如果前面所有字符都相同，则较短的单词应该排在前面
        return len1 <= len2;
    }
}
