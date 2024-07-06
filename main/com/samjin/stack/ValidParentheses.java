package com.samjin.stack;

import java.util.Stack;

/**
 * Created by sjjin on 12/13/17.
 */
public class ValidParentheses {


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        String left = "{[(";
        String right = "}])";

        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);

            if (left.indexOf(c) >= 0 ){
                stack.push(c);
            }

            if (right.indexOf(c) >= 0){
                if(stack.isEmpty()) return false;
                if(right.indexOf(c) == left.indexOf(stack.peek()) ){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();


















//        Stack<Character> stack = new Stack<>();
//
//        String left = "{([";
//        String right = "})]";
//
//        for(int i = 0; i < s.length(); i++){
//
//            char c = s.charAt(i);
//
//            if( left.indexOf(c) >= 0 ) stack.push(c);
//            if( right.indexOf(c) >= 0 ){
//                if( !stack.isEmpty() && right.indexOf(c) == left.indexOf(stack.peek())){
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
    }
}
