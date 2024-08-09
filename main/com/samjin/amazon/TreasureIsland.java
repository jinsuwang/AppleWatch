package com.samjin.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    public int treasureIsland(char[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 'D'; // mark as visited
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                if (grid[x][y] == 'X') {
                    return steps;
                }

                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 'D') {
                        queue.offer(new int[]{nx, ny});
                        grid[nx][ny] = 'D'; // mark as visited
                    }
                }
            }
            steps++;
        }

        return -1; // If there's no path to the treasure

    }
}
