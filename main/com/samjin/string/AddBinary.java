package com.samjin.string;

/**
 * Created by sjjin on 9/11/17.
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int maxLen = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < maxLen; i ++ ){
            int tmpA = a.length() > i ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int tmpB = b.length() > i ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.insert(0, (tmpA + tmpB + carry) % 2);
            carry = (tmpA + tmpB + carry) > 1 ? 1 : 0;
        }

        if (carry > 0) sb.insert(0,1);
        return sb.toString();
    }
}
