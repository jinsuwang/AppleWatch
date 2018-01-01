package com.samjin.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {

    Subsets ins = new Subsets();

    @Test
    public void subsetsDfs() {
        int[] input = new int[]{1,2,3};
        List<List<Integer>> res = ins.subsetsDfs(input);
        System.out.println(res);
    }
}