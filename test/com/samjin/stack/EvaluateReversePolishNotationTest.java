package com.samjin.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluateReversePolishNotationTest {

    EvaluateReversePolishNotation ins = new EvaluateReversePolishNotation();

    @Test
    public void evalRPN() {
        String[] input = new String[]{"2", "1", "+", "3", "*"};
//        String[] input2 = new String[]{"2","1","+","3","*"};

        System.out.println(ins.evalRPN(input));
    }
}