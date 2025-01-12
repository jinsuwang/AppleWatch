package com.samjin.string;

public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        // 检查 target 中是否有 source 无法覆盖的字符
        boolean[] sourceSet = new boolean[26];
        for (char c : source.toCharArray()) {
            sourceSet[c - 'a'] = true;
        }
        for (char c : target.toCharArray()) {
            if (!sourceSet[c - 'a']) {
                return -1; // 如果 target 中有 source 没有的字符，直接返回 -1
            }
        }

        int i = 0, j = 0;
        int subsequences = 0;

        while (j < target.length()) {
            i = 0; // 每次重置 source 指针
            subsequences++;
            while (i < source.length() && j < target.length()) {
                if (source.charAt(i) == target.charAt(j)) {
                    j++;
                }
                i++;
            }
        }

        return subsequences;
    }
}
