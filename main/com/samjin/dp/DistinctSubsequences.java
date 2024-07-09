package com.samjin.dp;

import java.sql.SQLOutput;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        MetricsUtil.print(dp);
        System.out.println("=======");


        for(int i = 1; i <= s.length(); i++){
            for (int j =1; j <= t.length(); j++){

                System.out.println("i->" + i + ";j->" + j);
                System.out.println("i is " + s.charAt(i-1) + ";j is " + t.charAt(j-1));


                System.out.println();

                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }

                MetricsUtil.print(dp);
                System.out.println("=======");
            }
        }

        return dp[s.length()][t.length()];
    }
}
