package com.samjin.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 9/6/17.
 */
public class RotateFunctionTest {
    @Test
    public void maxRotateFunction() throws Exception {

        RotateFunction instance = new RotateFunction();

        int[] input1 = new int[]{4, 3, 2, 6};

        int expected1 = 26;

        Assert.assertEquals(expected1, instance.maxRotateFunction(input1));
    }
}