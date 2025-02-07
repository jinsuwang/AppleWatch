package com.samjin.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 1. 先找到所有腐烂橘子，并记录新鲜橘子的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // 将腐烂橘子加入队列
                } else if (grid[i][j] == 1) {
                    freshCount++; // 统计新鲜橘子数量
                }
            }
        }

        // 如果没有新鲜橘子，直接返回 0
        if (freshCount == 0) return 0;

        // 方向数组（上、下、左、右）
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        // 2. 开始 BFS 传播
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotting = false;

            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                // 遍历四个方向
                for (int[] dir : directions) {
                    int newRow = r + dir[0], newCol = c + dir[1];

                    // 判断是否在范围内，且是新鲜橘子
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // 变为腐烂橘子
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--; // 新鲜橘子减少
                        hasRotting = true;
                    }
                }
            }

            // 只有当本轮有橘子腐烂，才增加分钟数
            if (hasRotting) minutes++;
        }

        // 3. 判断是否还有新鲜橘子
        return freshCount == 0 ? minutes : -1;
    }
}
