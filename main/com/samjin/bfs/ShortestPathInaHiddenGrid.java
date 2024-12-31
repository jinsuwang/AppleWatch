package com.samjin.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInaHiddenGrid {

      interface GridMaster {
      boolean canMove(char direction);
      void move(char direction);
      boolean isTarget();
  }
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char[] DIR_CHARS = {'U', 'D', 'L', 'R'};
    private static final char[] REVERSE_DIR_CHARS = {'D', 'U', 'R', 'L'}; // 反向方向
    // 定义迷宫的虚拟地图
    private static final int WALL = -1;
    private static final int UNKNOWN = 0;
    private static final int EMPTY = 1;
    private static final int TARGET = 2;

    // 用于存储迷宫的结构
    private int[][] grid;
    private int startX, startY, targetX = -1, targetY = -1;
    private int n = 201; // 虚拟迷宫大小为 201 x 201，中心点是 (100, 100)

    public int findShortestPath(GridMaster master) {
        grid = new int[n][n];
        startX = startY = 100; // 起点是中心位置

        // DFS 构建虚拟迷宫
        dfs(master, startX, startY);

        // 如果没有找到目标，返回 -1
        if (targetX == -1 || targetY == -1) return -1;

        // BFS 查找最短路径
        return bfs();
    }

    private void dfs(GridMaster master, int x, int y) {
        if (master.isTarget()) {
            grid[x][y] = TARGET;
            targetX = x;
            targetY = y;
        } else {
            grid[x][y] = EMPTY;
        }

        // 遍历四个方向
        for (int i = 0; i < 4; i++) {
            int newX = x + DIRS[i][0];
            int newY = y + DIRS[i][1];

            // 如果这个位置还没有探索过，并且可以移动，继续探索
            if (grid[newX][newY] == UNKNOWN && master.canMove(DIR_CHARS[i])) {
                // 移动到新的位置
                master.move(DIR_CHARS[i]);
                // 递归探索新的位置
                dfs(master, newX, newY);
                // 回溯到原来的位置
                master.move(REVERSE_DIR_CHARS[i]);
            }
        }
    }

    private int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                // 如果到达了目标位置，返回步数
                if (x == targetX && y == targetY) {
                    return steps;
                }

                // 继续向四个方向扩展
                for (int j = 0; j < 4; j++) {
                    int newX = x + DIRS[j][0];
                    int newY = y + DIRS[j][1];
                    // 如果新位置是空的，并且没有访问过，加入队列
                    if (grid[newX][newY] != WALL && !visited[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }

        return -1; // 如果找不到路径，返回 -1
    }

}
