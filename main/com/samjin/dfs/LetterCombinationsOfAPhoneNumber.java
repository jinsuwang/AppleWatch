package com.samjin.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {

        Map<Character, String> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        if( digits == null || digits.isEmpty() ) return res;

        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfs(res, sb, digits, map);

        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String digits, Map<Character, String> map) {
        if( sb.length() == digits.length() ){
            res.add(sb.toString());
            return;
        }

        for( char c : map.get(digits.charAt(sb.length())).toCharArray()) {
            sb.append(c);
            dfs(res,sb,digits,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
