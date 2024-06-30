package com.samjin.sortandsearch;

import org.junit.Test;

import java.util.List;

public class BinarySearchTest {


    BinarySearch bs = new BinarySearch();

    @Test
    public void search() {

        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        int target = 6;

        assert(5 == bs.search(input, target));}
}
