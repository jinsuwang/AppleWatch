package com.samjin.twopointer;

/**
 * Created by sjjin on 12/14/17.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return findMedianSortedArraysHelper( nums1, 0, nums2, nums2.length-1 );

    }

    private double findMedianSortedArraysHelper(int[] nums1, int i1, int[] nums2, int i2) {
        return 0;

    }
}
