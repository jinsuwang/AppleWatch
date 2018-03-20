package com.samjin.array;

public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int flag = 1;
        int i = 0;
        long res = 0;

        while(str.charAt(i) == ' '){
            i++;
        }
        if(str.charAt(i) == '+') i++;
        else if(str.charAt(i) == '-'){
            flag = -1;
            i++;
        }
        while(i < str.length() && Character.isDigit(str.charAt(i))){
            res = res * 10 + str.charAt(i) - '0';
            i++;
            if(res * flag > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(res * flag < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return flag * (int)res;
    }
}
