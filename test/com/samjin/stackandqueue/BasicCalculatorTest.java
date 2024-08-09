package com.samjin.stackandqueue;

import org.junit.Test;

public class BasicCalculatorTest {

    BasicCalculator ins = new BasicCalculator();

    @Test
    public void calculate() {
        System.out.println(ins.calculate("1+(4+5+2)"));

        //System.out.println(ins.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    @Test
    public void calculate2(){
        System.out.println(ins.calculate2(" 3+5 / 2"));
    }
}