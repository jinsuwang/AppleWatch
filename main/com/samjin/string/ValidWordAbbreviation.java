package com.samjin.string;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0')
                    return false;

                int curr = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    curr = curr * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += curr;
            } else {
                if (word.charAt(i) != abbr.charAt(j))
                    return false;
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
