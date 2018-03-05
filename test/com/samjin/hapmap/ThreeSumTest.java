package com.samjin.hapmap;

import com.samjin.hashmap.ThreeSum;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ThreeSumTest {

    ThreeSum ins;

    @Before
    public void setUp() throws Exception {
        ins = new ThreeSum();
    }

    @Test
    public void threeSum() {
        int[] input = new int[]{-2,0,1,1,2};
//        int[] input = new int[]{0,0,0,0};

        List<List<Integer>> ret = ins.threeSum(input);

        System.out.println(ret);
    }
}