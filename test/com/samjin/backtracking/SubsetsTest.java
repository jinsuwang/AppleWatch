package com.samjin.backtracking;

import org.junit.Test;

import java.util.List;

public class SubsetsTest {

    Subsets ins = new Subsets();

    @Test
    public void subsetsDfs() {
        int[] input = new int[]{1,2,3};
        List<List<Integer>> res = ins.subsetsDfs(input);
        System.out.println(res);
    }
}