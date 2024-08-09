package com.samjin.stackandqueue;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();


        String operators = "+-*/";

        for(int i = 0; i < tokens.length; i++ ){
            if(operators.lastIndexOf(tokens[i]) < 0 ){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                int a = stack.pop();
                int b = stack.pop();
//                System.out.println(String.format("%d %s %d", b, tokens[i], a));
                stack.push(calculate(b, a, tokens[i]));
            }
        }
        return stack.peek();
    }

    private Integer calculate(Integer b, Integer a, String token) {

        if(token == "+") return b + a;
        if(token == "-") return b - a;
        if(token == "*") return b * a;
        if(token == "/") return b / a;
        return 0;
    }
}
