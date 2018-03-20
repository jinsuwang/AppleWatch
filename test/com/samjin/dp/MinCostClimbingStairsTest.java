package com.samjin.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostClimbingStairsTest {

    MinCostClimbingStairs ins = new MinCostClimbingStairs();

    @Test
    public void minCostClimbingStairs() {
        System.out.println(ins.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(ins.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }


}