package com.samjin.string;

public class CountAndSay {

    public String countAndSay(int n) {
        // 初始第一项
        String result = "1";

        // 从第二项开始迭代，直到第 n 项
        for (int i = 2; i <= n; i++) {
            result = generateNext(result);
        }

        return result;
    }

    private String generateNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        // 遍历当前字符串 s
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // 如果相邻字符相同，计数增加
            } else {
                // 否则，拼接前一个字符的计数和字符本身
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1; // 重置计数
            }
        }

        // 拼接最后一组字符的计数和字符
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }
}
