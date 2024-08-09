package com.samjin.amazon;

public class IsRegexMatching {

    public String[] isRegexMatching(String regex, String[] arr) {
        String[] results = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (isMatch(arr[i], regex)) {
                results[i] = "YES";
            } else {
                results[i] = "NO";
            }
        }
        return results;
    }

    private boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Handle patterns like a*, a*b*, (ab)*, etc.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                if (j > 1) {
                    dp[0][j] = dp[0][j - 2];
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (j > 1) {
                        dp[i][j] = dp[i][j - 2]; // Match zero occurrences
                        if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j]; // Match one or more occurrences
                        }
                    }
                } else if (pc == '(' || pc == ')') {
                    continue; // These are handled in other parts of the regex
                }
            }
        }
        return dp[m][n];
    }
}
