package com.samjin.array;

public class StringCompression {

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;  // 写指针
        int i = 0;      // 读指针

        while (i < n) {
            char currentChar = chars[i];
            int count = 0;

            // 统计当前字符的出现次数
            while (i < n && chars[i] == currentChar) {
                i++;
                count++;
            }

            // 写入字符
            chars[write++] = currentChar;

            // 如果字符出现次数超过1，写入次数
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
