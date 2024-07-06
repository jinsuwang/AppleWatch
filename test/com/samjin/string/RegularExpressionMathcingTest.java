package com.samjin.string;

import org.junit.Test;

public class RegularExpressionMathcingTest {

    RegularExpressionMatching ins = new RegularExpressionMatching();

    @Test
    public void isMatch() {

        String s = "aaaaaa";
        String p = "a*";

        System.out.println(ins.isMatch(s,p));
    }
}