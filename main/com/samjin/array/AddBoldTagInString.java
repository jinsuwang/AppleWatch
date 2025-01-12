package com.samjin.array;

public class AddBoldTagInString {

    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        int boldEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    boldEnd = Math.max(boldEnd, i + word.length());
                }
            }

            bold[i] = boldEnd > i;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!bold[i]) {
                res.append(c);
                continue;
            }

            // first bold
            if(i == 0 || !bold[i - 1]) {
                res.append("<b>");
            }
            res.append(c);
            // last bold
            if(i == s.length() - 1 || !bold[i + 1]) {
                res.append("</b>");
            }
        }

        return res.toString();
    }
}
