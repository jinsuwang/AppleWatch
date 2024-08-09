package com.samjin.stackandqueue;

import org.junit.Test;

public class BaseballGameTest {

    BaseballGame ins = new BaseballGame();

    @Test
    public void testCalPoints() {
        System.out.println(ins.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(ins.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}