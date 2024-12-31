package com.samjin.segmenttree;

public class RangeSumQuery2DImmutable {


    private int[][] prefixSum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return;
        int cols = matrix[0].length;

        // 构建 prefixSum 矩阵，大小为 (rows + 1) x (cols + 1)
        prefixSum = new int[rows + 1][cols + 1];

        // 计算前缀和
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1]
                - prefixSum[row1][col2 + 1]
                - prefixSum[row2 + 1][col1]
                + prefixSum[row1][col1];
    }
}
