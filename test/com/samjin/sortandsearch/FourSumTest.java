package com.samjin.sortandsearch;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FourSumTest {

    FourSum ins = new FourSum();

    @Test
    public void fourSum() {

        int[] input = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> res = ins.fourSum(input, target);
        res.forEach(System.out::println);
    }
}