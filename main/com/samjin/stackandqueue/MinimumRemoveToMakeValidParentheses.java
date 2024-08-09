package com.samjin.stackandqueue;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') {
                // add index to stack
                st.add(i);
            }
            if (sb.charAt(i) == ')') {
                if (!st.empty()) {
                    st.pop();
                } else {
                    // need to replace
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!st.empty()) {
            sb.setCharAt(st.pop(), '*');
        }

        return sb.toString().replaceAll("\\*", "");
    }

}
