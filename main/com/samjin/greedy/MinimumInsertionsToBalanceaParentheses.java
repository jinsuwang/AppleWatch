package com.samjin.greedy;

public class MinimumInsertionsToBalanceaParentheses {

    public int minInsertions(String s) {
        int count = 0; // 用于记录未闭合的左括号 '(' 的数量
        int res = 0; // 用于记录所需的插入次数

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else{
                if ( i+1 < s.length() && s.charAt(i+1) == ')'){
                    count--;
                    i++;
                }else{
                    res++;
                    count--;
                }
            }
            if (count < 0){
                res++;
                count = 0;
            }
        }
        res += count * 2;
        return res;
    }
}
