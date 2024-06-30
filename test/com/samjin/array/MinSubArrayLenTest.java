package com.samjin.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinSubArrayLenTest {

    MinSubArrayLen t = new MinSubArrayLen();

    @Test
    public void minSubArrayLen() {
        int res = t.minSubArrayLen(7, new int[]{2,3,1,2,4,3});

        System.out.println(res);

    }
}