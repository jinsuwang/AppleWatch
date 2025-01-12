package com.samjin.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {

    public int minKnightMoves(int x, int y) {
        // 转化为第一象限
        x = Math.abs(x);
        y = Math.abs(y);

        // 定义骑士的 8 个可能移动
        int[][] directions = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        // BFS 初始化
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new int[]{0, 0});
        visited.add("0,0");

        int steps = 0;

        // 开始 BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currX = current[0];
                int currY = current[1];

                // 如果到达目标点
                if (currX == x && currY == y) {
                    return steps;
                }

                // 遍历 8 个方向
                for (int[] direction : directions) {
                    int nextX = currX + direction[0];
                    int nextY = currY + direction[1];
                    String key = nextX + "," + nextY;

                    // 限制到第一象限范围
                    if (!visited.contains(key) && nextX >= -2 && nextY >= -2) {
                        queue.offer(new int[]{nextX, nextY});
                        visited.add(key);
                    }
                }
            }
            steps++;
        }

        return -1; // 不会到达这里
    }
}
