package com.samjin.backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CombinationsTest {

    @Test
    public void combine() {

        Combinations combinations = new Combinations();
        List<List<Integer>> res = combinations.combine(3,2);

        res.forEach(System.out::println);

    }
}