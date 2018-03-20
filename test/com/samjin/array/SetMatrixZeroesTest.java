package com.samjin.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SetMatrixZeroesTest {

    SetMatrixZeroes ins = new SetMatrixZeroes();

    @Test
    public void setZeroes() {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  0, 11, 12},
                {13, 14, 15, 16}
        };


        int[][] matrix2 = {
                {0,0,0,5},
                {4,3,1,4},
                {0,1,1,4},
                {1,2,1,3},
                {0,0,1,1}
        };


        ins.setZeroes(matrix2);

//        for(int[] arr : matrix2){
//            System.out.println(Arrays.toString(arr));
//        }

    }
}