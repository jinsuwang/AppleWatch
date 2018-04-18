package com.samjin.string;

public class RegularExpressionMathcing {


    //        String s = "aaaaaa";
    //        String p = "a*";
    public boolean isMatch(String s, String p) {
        // p size is 0
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        // p size is 1;
        if(p.length() == 1){
            return s.length() == 1 && ( s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }

        // p size is > 1 and second char is not '*'
        if(p.charAt(1) != '*'){
            if(s.length() == 0) return false;
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }

        // p size is > 1 and second char is '*'
        while(s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')){
            if(isMatch(s, p.substring(2))){
                return true;
            }
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }
}
