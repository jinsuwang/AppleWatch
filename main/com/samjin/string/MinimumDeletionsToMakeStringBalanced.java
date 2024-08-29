package com.samjin.string;

public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {

        int n = s.length();

        // Prefix array to count the number of 'b's up to each index
        int[] pre = new int[n];
        pre[0] = (s.charAt(0) == 'b') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
        }

        // Suffix array to count the number of 'a's from each index to the end
        int[] suf = new int[n];
        suf[n - 1] = (s.charAt(n - 1) == 'a') ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        // Calculate the minimum deletions
        int ret = Math.min(pre[n - 1], suf[0]);
        for (int i = 0; i < n - 1; i++) {
            ret = Math.min(ret, pre[i] + suf[i + 1]);
        }

        return ret;
    }
}
