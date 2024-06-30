package com.samjin.backtracking;

import org.junit.Test;

import java.util.List;

public class GrayCodeTest {

    GrayCode grayCode = new GrayCode();

    @Test
    public void grayCode() {
        List<Integer> res = grayCode.grayCode(2);

        System.out.println(res);
    }
}