package com.samjin.dfs;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPathInaMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols]; // 存储每个位置的最长路径
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 四个方向：右、下、左、上

        // 将所有单元格按照值排序
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells.add(new int[]{i, j});
            }
        }
        cells.sort((a, b) -> Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));

        // 动态规划计算
        int maxLength = 1; // 最短路径至少为 1
        for (int[] cell : cells) {
            int row = cell[0], col = cell[1];
            dp[row][col] = 1; // 初始化
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && matrix[newRow][newCol] < matrix[row][col]) {
                    dp[row][col] = Math.max(dp[row][col], 1 + dp[newRow][newCol]);
                }
            }
            maxLength = Math.max(maxLength, dp[row][col]);
        }

        return maxLength;
    }
}
