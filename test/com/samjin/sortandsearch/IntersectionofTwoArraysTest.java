package com.samjin.sortandsearch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IntersectionofTwoArraysTest {

    IntersectionofTwoArrays ins = new IntersectionofTwoArrays();

    @Test
    public void test(){
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        System.out.println(Arrays.toString(ins.intersection(nums1,nums2)));

    }
}