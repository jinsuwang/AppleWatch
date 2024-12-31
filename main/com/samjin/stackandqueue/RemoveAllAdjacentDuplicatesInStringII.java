package com.samjin.stackandqueue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    // 自定义的类，用于存储字符和其连续出现的次数
    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        // 栈中的元素是字符以及该字符连续出现的次数
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果栈不为空且栈顶的字符与当前字符相同
            if (!stack.isEmpty() && stack.peek().ch == c) {
                // 增加栈顶字符的出现次数
                stack.peek().count++;
                // 如果该字符的出现次数等于 k，则从栈中移除
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                // 如果当前字符与栈顶不同，将字符和计数 1 压入栈
                stack.push(new Pair(c, 1));
            }
        }

        // 重新构建结果字符串
        StringBuilder result = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                result.append(p.ch);
            }
        }

        return result.toString();
    }
}
