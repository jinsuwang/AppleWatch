package com.samjin.stackandqueue;

import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicates(String s) {

        if (s == null) return null;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            }else{
                stack.pop();
            }
        }

        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }
}
