package com.samjin.backtracking;

import org.junit.Test;

import java.util.List;

public class GenerateParanthesisTest {

    GenerateParanthesis ins = new GenerateParanthesis();

    @Test
    public void generateParenthesis() {

        List<String> res = ins.generateParenthesis(3);
        System.out.println(res);
    }
}