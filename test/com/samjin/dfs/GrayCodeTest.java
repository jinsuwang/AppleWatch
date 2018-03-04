package com.samjin.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GrayCodeTest {

    GrayCode grayCode = new GrayCode();

    @Test
    public void grayCode() {
        List<Integer> res = grayCode.grayCode(2);

        System.out.println(res);
    }
}