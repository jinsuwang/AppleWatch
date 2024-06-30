package com.samjin.backtracking;

import org.junit.Test;

import java.util.List;

public class SubsetsIITest {

    SubsetsII ins = new SubsetsII();

    @Test
    public void subsetsWithDup() {

        int[] input = new int[]{1,2,2};

        List<List<Integer>> res = ins.subsetsWithDup(input);

        System.out.println(res);

    }
}