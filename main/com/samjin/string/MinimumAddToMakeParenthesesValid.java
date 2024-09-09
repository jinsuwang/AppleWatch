package com.samjin.string;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String s) {

        int balance = 0;  // 记录左括号和右括号的平衡情况
        int result = 0;   // 记录需要的最少操作次数

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 遇到左括号，增加平衡
                balance++;
            } else {
                // 遇到右括号，减少平衡
                balance--;

                // 如果平衡变为负数，表示右括号比左括号多，修正它
                if (balance < 0) {
                    result++;
                    balance = 0;  // 重新平衡
                }
            }
        }

        // 返回需要的修正次数加上未匹配的左括号数量
        return result + balance;


    }
}
