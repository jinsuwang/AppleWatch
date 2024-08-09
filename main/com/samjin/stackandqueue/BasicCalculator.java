package com.samjin.stackandqueue;

import java.util.Stack;

public class BasicCalculator {

    //testcase1: 1+(4+5+2)
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // find full value
                int tmp = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    tmp = 10 * tmp + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * tmp;
                i--; // move back for one step;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                // cache all current variable.
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if( c == ')'){
                res *= stack.pop(); // assign sign to current level result.
                res += stack.pop();
            }
        }
        return res;
    }

    /**
     * "3+2*2" = 7
     * " 3/2 " = 1
     * " 3+5 / 2 " = 5
     */
    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int tmp = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                    i++;
                }
                while(i < s.length() && s.charAt(i) == ' '){i++;}
                if (sign == '+' || sign == '-' || sign == '*' || sign == '/' || i == s.length() - 1) {
                    if (sign == '+') {
                        stack.push(tmp);
                    } else if (sign == '-') {
                        stack.push(-tmp);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * tmp);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / tmp);
                    }
                    if(i < s.length()){
                        sign = s.charAt(i);
                    }
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
