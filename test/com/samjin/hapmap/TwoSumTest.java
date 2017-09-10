package com.samjin.hapmap;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 8/25/17.
 */
public class TwoSumTest {

    private TwoSum twoSum;

    @Before
    public void setup(){
        twoSum = new TwoSum();
    }

    @Test
    public void getTwoSum() throws Exception {

        int[] test = new int[]{ 2,4,6,8,7};
        int sum = 9;

        int[] result = twoSum.getTwoSum(test, sum);

        System.out.println(Arrays.toString(result));
    }

}
