package com.samjin.stack;

import java.util.Stack;

public class TernaryExpressionParser {

    // Input1: "T?2:3"
    // Input2: "T?T?F:5:3"

    private String eval(String expression) {
        if (expression.length() != 5) return "";
        return expression.charAt(0) == 'T' ? expression.charAt(2) + "" : expression.charAt(4) + "";
    }

    public String parseTernary(String expression) {
        Stack<Integer> stack = new Stack<>();
        String res = expression;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '?'){
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            res = res.substring(0, index - 1) + eval(res.substring(index-1,index+4)) + res.substring(index+4);
        }
        return res;
    }





    String test = "T?3:5";

    public String parseTernary2(String expression){
        Stack<Character> stack = new Stack<Character>();
        for(int i = expression.length() - 1; i >= 0; i--){
            char c = expression.charAt(i);
            if(!stack.empty() && stack.peek() == '?'){
                stack.pop(); // throw '?'
                char left = stack.pop();
                stack.pop(); // throw ':'
                char right = stack.pop();
                stack.push( c == 'T' ? left : right);
            }else{
                stack.push(c);
            }
        }
        return Character.toString(stack.peek());
    }
}
