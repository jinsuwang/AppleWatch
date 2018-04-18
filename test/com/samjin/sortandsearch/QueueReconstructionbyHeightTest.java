package com.samjin.sortandsearch;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QueueReconstructionbyHeightTest {

    QueueReconstructionbyHeight ins = new QueueReconstructionbyHeight();

    @Test
    public void reconstructQueue() {

        int[][] input = new int[][]{
            new int[]{7,0},
            new int[]{4,4},
            new int[]{7,1},
            new int[]{5,0},
            new int[]{6,1},
            new int[]{5,2}
        };


        int[][] res = ins.reconstructQueue(input);

        for(int[] e : res){
            System.out.println(Arrays.toString(e));
        }
    }
}