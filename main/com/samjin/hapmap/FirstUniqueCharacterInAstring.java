package com.samjin.hapmap;

/**
 * Created by sjjin on 9/5/17.
 */
public class FirstUniqueCharacterInAstring {


    // solution 1. counting the word
    public int firstUniqChar(String s) {

        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    //solution 2. using pointer
    public int firstUniqChar2(String s){
        return 0;
    }

}
