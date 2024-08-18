package com.samjin.stackandqueue;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {


    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(currentString);  // 保存当前字符串
                currentString = new StringBuilder();  // 开始新的子字符串
            } else if (c == ')') {
                currentString.reverse();  // 反转当前子字符串
                currentString = stack.pop().append(currentString);  // 将反转后的子字符串添加到上一个保存的字符串中
            } else {
                currentString.append(c);  // 加入普通字符
            }
        }

        return currentString.toString();

    }
}
