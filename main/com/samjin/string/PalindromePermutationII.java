package com.samjin.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        int[] dd = new int[26];

        for(char c : s.toCharArray()) {
            dd[c - 'a']++;
        }

        int odd = 0;
        char oddC = 'a';

        for(int i = 0; i < 26; i++) {
            if(dd[i] % 2 == 1) {
                odd++;
                oddC = (char)('a' + i);
            }
        }

        if(odd > 1){
            return new ArrayList<>();
        }

        String base = "";
        int ll = s.length();

        if(odd == 1) {
            base = oddC + "";
            dd[oddC - 'a'] -= 1;
            ll -= 1;
        }

        List<String> res = new ArrayList<>();
        helper(res, base, dd, ll);
        return res;
    }

    private void helper(List<String> res, String base, int[] dd, int ll) {
        if(ll == 0){
            res.add(base);
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(dd[i] == 0) continue;

            dd[i] -= 2;
            char c = (char)('a' + i);
            helper(res, c + base + c, dd, ll - 2);
            dd[i] += 2;
        }

    }
}
