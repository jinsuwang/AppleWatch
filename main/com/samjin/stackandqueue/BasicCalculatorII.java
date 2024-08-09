package com.samjin.stackandqueue;
import java.util.Stack;
public class BasicCalculatorII {

    public int calculate(String s) {
        int len = s.length();
        if (s == null || len == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < len; i++) {

            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                // 如果当前数字的后边也是数字，那就要*10来得到这整个的数字
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);

                sign = s.charAt(i);
                num = 0;
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
