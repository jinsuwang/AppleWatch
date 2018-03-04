package com.samjin.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsIITest {

    SubsetsII ins = new SubsetsII();

    @Test
    public void subsetsWithDup() {

        int[] input = new int[]{1,2,2};

        List<List<Integer>> res = ins.subsetsWithDup(input);

        System.out.println(res);

    }
}