package com.samjin.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            String key = helper(s);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> l : map.values()) {
            res.add(l);
        }

        return res;
    }

    private String helper(String s) {
        int dis = s.charAt(0) - 'a';

        char[] carr = new char[s.length()];
        carr[0] = 'a';

        for(int i = 1; i < s.length(); i++) {
            char c = (char)(s.charAt(i) - dis);
            if(c < 'a') {
                c += 26;
            }

            carr[i] = c;
        }

        return new String(carr);
    }

}



