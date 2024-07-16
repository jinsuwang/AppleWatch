package com.samjin.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortedArrayTest {

    MergeSortedArray ins = new MergeSortedArray();

    @Test
    public void merge() {
        int[] num1 = new int[]{4,5,6,-1,-1,-1};
        int[] num2 = new int[]{1,2,3};

        ins.merge(num1, 3, num2, 3);

        System.out.println(Arrays.toString(num1));
    }
}