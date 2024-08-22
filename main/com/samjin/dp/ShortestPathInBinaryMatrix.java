package com.samjin.dp;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // 如果起点或终点是 1，返回 -1
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // 八个方向的移动
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        // BFS 队列，存储当前点和路径长度
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});  // {row, col, path_length}
        grid[0][0] = 1; // 标记为已访问

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], length = cell[2];

            // 如果到达右下角，返回路径长度
            if (row == n - 1 && col == n - 1) {
                return length;
            }

            // 遍历八个方向
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // 检查边界条件和是否可以继续前进
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol, length + 1});
                    grid[newRow][newCol] = 1; // 标记为已访问
                }
            }
        }

        // 如果无法到达右下角，返回 -1
        return -1;

    }
}
