package com.samjin.heap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 9/7/17.
 */
public class SortCharactersByFrequencyTest {
    @Test
    public void frequencySort() throws Exception {

        SortCharactersByFrequency ins = new SortCharactersByFrequency();
        String input1 = "Aabb";
        String res1 = ins.frequencySort(input1);
        System.out.printf(res1);

    }

}