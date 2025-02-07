package com.samjin.string;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for(int l : left) {
                    for(int r : right){
                        if(c == '+'){
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }

        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }

}
