package com.samjin.string;

/**
 * Created by sjjin on 12/12/17.
 */
public class LongestPalindromicSubstring {


    /* Time Limit Exceeded */
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        String ret = null;

        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            String s1 = getLongest(s, i, i);
            String s2 = getLongest(s, i, i + 1);

            if (s1.length() > max) {
                max = Math.max(max, s1.length());
                ret = s1;
            }

            if (s2.length() > max) {
                max = Math.max(max, s2.length());
                ret = s2;
            }
        }

        return ret;
    }

    public String getLongest(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            // when i is in the center.
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
