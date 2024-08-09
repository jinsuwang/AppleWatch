package com.samjin.stackandqueue;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] elements = path.split("/");

        for (int i = 0; i < elements.length; i++){

            String curr = elements[i].trim();
            if(curr == "" || curr == "/" || curr.equals(".")) continue;
            if (curr.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(curr);
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }

        return res.length() == 0 ? "/" : res;
    }
}
