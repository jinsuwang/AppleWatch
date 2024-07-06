package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    private List<String> list = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, 0);
        return list;
    }

    public void dfs(String str, int l, int r) {
        if (l == 0 && r == 0) {
            list.add(str);
            return;
        }

        if (l > 0) {
            String s = str + "(";
            dfs(s, l-1, r+1);
        }
        if (r > 0) {
            String s = str + ")";
            dfs(s, l, r-1);
        }
    }
}
