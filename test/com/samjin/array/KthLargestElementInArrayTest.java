package com.samjin.array;

import com.samjin.heap.KthLargestElementInArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sjjin on 12/14/17.
 */
public class KthLargestElementInArrayTest {

    KthLargestElementInArray ins;

    @Before
    public void setUp() throws Exception {
        ins = new KthLargestElementInArray();
    }

    @Test
    public void findKthLargest() throws Exception {

        int[] input = new int[]{3,2,1,5,6,4};

        int expected = 5;

        Assert.assertEquals(expected, ins.findKthLargest(input,2));


    }

}