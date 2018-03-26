package com.samjin.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {

    TrappingRainWater ins = new TrappingRainWater();

    @Test
    public void trap() {

        int[] test = new int[]{ 0,1,0,2,1,0,1,3,2,1,2,1 };
        System.out.println(ins.trap(test));

    }
}