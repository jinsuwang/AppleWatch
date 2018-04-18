package com.samjin.dfs;

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
            System.out.println(String.format("l: %d, r: %d, str %s", l, r, str));
            list.add(str);
            return;
        }

        System.out.println(String.format("l: %d, r: %d, str %s", l, r, str));


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
