package com.samjin.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RotateImageTest {

    RotateImage ins = new RotateImage();

    @Test
    public void rotate() {

        int[][] input = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        int[][] input2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        ins.rotate(input);

        for(int[] e : input)  System.out.println(Arrays.toString(e));

        ins.rotate(input2);

        for(int[] e : input2)  System.out.println(Arrays.toString(e));
    }
}