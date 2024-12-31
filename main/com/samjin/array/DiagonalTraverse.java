package com.samjin.array;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {

        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;

        int[] res = new int[m * n];

        int k = 0;

        for (int d = 0; d < m + n - 1; d++) {

            List<Integer> diagonal = new ArrayList<>();

            int row = d < n ? 0 : d - n + 1;
            int col = d < n ? d : n - 1;

            while (row < m && col >= 0) {
                diagonal.add(mat[row][col]);
                row++;
                col--;
            }

            // Add elements to the result in the correct order (either reverse or original)
            if (d % 2 == 0) {
                // If d is even, add elements in reverse order (up-right diagonal)
                for (int i = diagonal.size() - 1; i >= 0; i--) {
                    res[k++] = diagonal.get(i);
                }
            } else {
                // If d is odd, add elements in original order (down-left diagonal)
                for (int i = 0; i < diagonal.size(); i++) {
                    res[k++] = diagonal.get(i);
                }
            }
        }
        return res;
    }
}
