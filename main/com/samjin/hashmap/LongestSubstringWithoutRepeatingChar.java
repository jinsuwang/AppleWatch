package com.samjin.hashmap;

/**
 * Created by sjjin on 8/25/17.
 */
public class LongestSubstringWithoutRepeatingChar {


    public int run(String s) {

        if( s == null || s.length() == 0) return 0;
        if( s.length() == 1 ) return 1;

        // use array as map.
        int[] map = new int[256];

        int prev = 0;
        int curr = 0;
        int ans = 0;

        for( prev = 0; prev < s.length(); prev ++ ){
            while( curr < s.length() && map[s.charAt(curr)] == 0){
                map[s.charAt(curr)] = 1; // taken
                ans = Math.max(ans, curr - prev + 1);
                curr ++ ;
            }
            // find duplication
            map[s.charAt(prev)] = 0;
        }
        return ans;
    }
}
