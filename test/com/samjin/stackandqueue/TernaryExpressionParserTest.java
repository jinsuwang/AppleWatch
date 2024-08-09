package com.samjin.stackandqueue;

import org.junit.Test;

public class TernaryExpressionParserTest {

    TernaryExpressionParser ins = new TernaryExpressionParser();

    @Test
    public void parseTernary() {
        String testcase2 = "T?T?F:5:3";
        System.out.println(ins.parseTernary2(testcase2));
    }
}