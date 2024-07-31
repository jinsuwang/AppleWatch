package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, s, new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<List<String>> res, String s, ArrayList<String> temp, int start) {
        if (start == s.length()){
            //注意创建一个新的copy
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start + 1; i <= s.length(); i++) {
            if (isValid(s.substring(start, i))) {
                temp.add(s.substring(start, i));
                helper(res, s, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

}
