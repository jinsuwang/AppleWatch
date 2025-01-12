package com.samjin.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // 方向数组，用于四个方向的移动
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 使用 DFS 标记第一个岛屿为 2，并将边界点加入队列
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue, directions);
                    found = true;
                    break;
                }
            }
        }

        // BFS 扩展边界，寻找最短路径到第二个岛屿
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];

                    // 检查边界条件
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (grid[x][y] == 1) {
                            // 到达第二个岛屿
                            return steps;
                        }
                        if (grid[x][y] == 0) {
                            // 将水变为陆地并继续扩展
                            grid[x][y] = 2;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // 不会到达这里
    }

    private void dfs(int[][] grid, int x, int y, Queue<int[]> queue, int[][] directions) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) {
            return;
        }

        grid[x][y] = 2; // 标记为 2 表示已访问
        queue.offer(new int[]{x, y}); // 加入边界队列

        for (int[] direction : directions) {
            dfs(grid, x + direction[0], y + direction[1], queue, directions);
        }
    }
}
