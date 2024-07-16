package com.samjin.string;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int min = 0; // 最少需要 ) 的个数
        int max = 0; // 最多需要 ) 的个数

        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if(min > 0) min--; // (*)) - true, ((*)(*))((* - false
                max--;
            } else if (c == '*') {
                if(min > 0) min--; // 看作 ) - ()*** - true
                max++; // 看作 (
            }
            // ) 多于 ( 和 * 数量, 例: **)))
            if (max < 0) return false;
        }

        return min == 0;
    }
}
