package com.samjin.hashmap;

public class ValidAnagram {


    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] arr = new int[256];

        for(char c : s.toCharArray()) arr[c]++;
        for(char c : t.toCharArray()) arr[c]--;

        for(int i : arr){
            if(i != 0) return false;
        }
        return true;
    }

}
