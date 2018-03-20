package com.samjin.stack;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int val = 0;

        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < ops.length; i++ ){
            if(ops[i].matches("-?\\d+")){
                stack.push(Integer.valueOf(ops[i]));
            }else if(ops[i].equals("C")){
                stack.pop();
            }else if(ops[i].equals("D")){
                stack.push(stack.peek() * 2);
            }else if(ops[i].equals("+")){
                int last1 = stack.pop();
                int last2 = stack.peek();
                stack.push(last1);
                stack.push(last1+last2);
            }else{
                continue;
            }
        }
        while(!stack.isEmpty()){
            val += stack.pop();
        }
        return val;
    }
}
