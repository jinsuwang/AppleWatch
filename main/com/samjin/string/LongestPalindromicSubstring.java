package com.samjin.string;

/**
 * Created by sjjin on 12/12/17.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if(s == null || s.isEmpty()) return s;

        String ret = "";

        for(int i = 0; i < s.length(); i++){

            int j = i; int k = i;

            while( j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k) ){
                String staging = s.substring(j,k+1);
                if( staging.length() > ret.length() ) ret = staging;
                j--; k++;
            }

            j = i; k = i + 1;
            while( j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k) ){
                String staging = s.substring(j,k+1);
                if( staging.length() > ret.length() ) ret = staging;
                j--; k++;
            }
        }

        return ret;
    }
}
