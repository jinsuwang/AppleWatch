package com.samjin.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class TernaryExpressionParserTest {

    TernaryExpressionParser ins = new TernaryExpressionParser();

    @Test
    public void parseTernary() {
        String testcase2 = "T?T?F:5:3";
        System.out.println(ins.parseTernary2(testcase2));
    }
}