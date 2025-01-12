package com.samjin.string;

public class CountAndSay {

    public String countAndSay(int n) {
        String cas = "1";

        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            char curr = cas.charAt(0);
            int count = 0;

            for(int j = 0; j < cas.length(); j++){
                char c = cas.charAt(j);
                if(c == curr){
                    count++;
                } else {
                    sb.append(count).append(curr);
                    count = 1;
                    curr = cas.charAt(j);
                }
            }

            sb.append(count).append(curr);
            cas = sb.toString();
        }

        return cas;
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
    }
}
