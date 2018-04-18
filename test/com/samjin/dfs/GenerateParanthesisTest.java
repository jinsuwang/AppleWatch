package com.samjin.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateParanthesisTest {

    GenerateParanthesis ins = new GenerateParanthesis();

    @Test
    public void generateParenthesis() {

        List<String> res = ins.generateParenthesis(3);
        System.out.println(res);
    }
}