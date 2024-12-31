package com.samjin.stackandqueue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {
        // 使用栈保存非重复字符
        Stack<Character> stack = new Stack<>();

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果栈不为空并且栈顶字符与当前字符相同，则弹出栈顶
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                // 否则将当前字符压入栈
                stack.push(c);
            }
        }

        // 构建结果字符串
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
