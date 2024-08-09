package com.samjin.heap;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FindKPairsWithSmallestSumsTest {

    FindKPairsWithSmallestSums ins = new FindKPairsWithSmallestSums();

    @Test
    public void kSmallestPairs() {

        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};

        List<List<Integer>> res = ins.kSmallestPairs(nums1, nums2, 4);

        for (List<Integer> e : res){
            System.out.println(e);
        }
    }
}