package com.samjin.hashmap;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] map = new char[26];

        for (int i=0; i< s.length(); i++){
            int index = s.charAt(i) - 'a';
            map[index]++;
        }
        for (int i=0; i< t.length(); i++){
            int index = t.charAt(i) - 'a';
            map[index]--;
        }

        for(int i=0; i<map.length; i++){
            if (map[i]!= 0) return false;
        }
        return true;

    }
}
