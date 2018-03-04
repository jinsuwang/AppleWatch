package com.samjin.sortandsearch;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortingAlgorithmTest {

    int[] input;

    @Before
    public void setUp() throws Exception {
        input = new int[]{5,4,6,1,3,2};
    }

    @Test
    public void bubbleSort() {
    }

    @Test
    public void mergeSort() {
    }

    @Test
    public void quickSort() {
        SortingAlgorithm.quickSort(input);
        System.out.println(Arrays.toString(input));
    }
}