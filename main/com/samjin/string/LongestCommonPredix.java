package com.samjin.string;

public class LongestCommonPredix {

    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];

        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(pre)){
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }
}
