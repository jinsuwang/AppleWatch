package com.samjin.greedy;

public class FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找到当前 (i, j) 位置能放的最大值
                int val = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = val;
                // 更新对应的 rowSum 和 colSum
                rowSum[i] -= val;
                colSum[j] -= val;
            }
        }

        return matrix;
    }
}
