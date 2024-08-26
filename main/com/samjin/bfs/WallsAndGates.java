package com.samjin.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;

    // Directions array to simplify the process of moving in four possible directions (up, down, left, right)
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: Perform BFS from each gate
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            // Explore all four directions
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                // If the new position is out of bounds or not an empty room, skip it
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }

                // Update the distance to the nearest gate and add the position to the queue
                rooms[r][c] = rooms[row][col] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
