package com.samjin.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] cache = new boolean[s.length()+1];
        cache[0] = true;

        int maxLen = findMaxLen(wordDict);

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= maxLen && j <= i; j++){
                if(!cache[i-j]) continue;// do nothing.
                String tmp = s.substring(i-j, i);
                if (wordDict.contains(tmp)){
                   cache[i] = true;
                   break;
                }
            }
        }
        return cache[s.length()];
    }

    private int findMaxLen(List<String> wordDict) {
        int max = 0;
        for(String word : wordDict){
            max = Math.max(max, word.length());
        }
        return max;
    }
}
