package com.samjin.array;

import java.util.List;

public class SpiralMatrixII {



    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int value = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (left <= right && top <= bottom) {
            // Fill top row from left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            // Fill right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            // Fill bottom row from right to left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = value++;
            }
            bottom--;

            // Fill left column from bottom to top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = value++;
            }
            left++;
        }

        return matrix;

    }
}
