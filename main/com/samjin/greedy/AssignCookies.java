package com.samjin.greedy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int start = s.length - 1;

        for (int index = g.length - 1; index >= 0; index--){
            if (start >= 0 && g[index] <= s[start]){
                start--;
                count++;
            }
        }

        return count;
    }
}
