package com.samjin.dp;

public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1+1][len2+2];

        for(int i = 1; i < len1 + 1; i ++){
            for (int j = 1; j < len2 + 1; j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        if(dp[len1][len2] == len1){
            return true;
        }else{
            return false;
        }
    }
}
