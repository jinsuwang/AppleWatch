package com.samjin.hashmap;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(S == null || J == null ) return 0;
        Set<Character> set = new HashSet<>();
        for(char c : J.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(char c : S.toCharArray()){
            if(set.contains(c)) res ++;
        }
        return res;
    }
}
