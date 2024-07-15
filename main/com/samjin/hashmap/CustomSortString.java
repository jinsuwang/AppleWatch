package com.samjin.hashmap;

public class CustomSortString {

    public String customSortString(String order, String s) {
        int[] count = new int[26];
        // 统计每个字符
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        // 按照order的顺序加入每个str中的字符
        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                sb.append(c);
            }
            count[c - 'a'] = 0;
        }
        // 加入剩下的字符
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < count[c - 'a']; ++i) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
