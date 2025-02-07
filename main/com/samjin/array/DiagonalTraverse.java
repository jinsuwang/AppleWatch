package com.samjin.array;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] res = new int[m * n];
        int row = 0;
        int col = 0;
        int d = 1;

        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row -= d;
            col += d;

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = - d;
            }

            if (col >= n) {
                col = n - 1;
                row += 2;
                d = - d;
            }

            if (row < 0)  {
                row = 0;
                d = - d;
            }

            if (col < 0)  {
                col = 0;
                d = - d;
            }
        }

        return res;
    }
}
