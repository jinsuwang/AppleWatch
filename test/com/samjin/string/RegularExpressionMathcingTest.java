package com.samjin.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionMathcingTest {

    RegularExpressionMathcing ins = new RegularExpressionMathcing();

    @Test
    public void isMatch() {

        String s = "aaaaaa";
        String p = "a*";

        System.out.println(ins.isMatch(s,p));
    }
}