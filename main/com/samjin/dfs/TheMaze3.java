package com.samjin.dfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMaze3 {

    private static class Point {
        int x, y, dist;
        String path;
        Point(int x, int y, int dist, String path) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
    }

    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] distances = new int[m][n];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>(
                (a, b) -> a.dist == b.dist ? a.path.compareTo(b.path) : a.dist - b.dist
        );
        pq.offer(new Point(start[0], start[1], 0, ""));

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        String[] dirSymbols = {"r", "l", "d", "u"};

        while (!pq.isEmpty()) {
            Point current = pq.poll();

            // If we've reached the destination, return the path
            if (current.x == destination[0] && current.y == destination[1]) {
                return current.path;
            }

            for (int i = 0; i < directions.length; i++) {
                int[] direction = directions[i];
                int x = current.x;
                int y = current.y;
                int dist = current.dist;
                String path = current.path;

                while (x + direction[0] >= 0 && x + direction[0] < m &&
                        y + direction[1] >= 0 && y + direction[1] < n &&
                        maze[x + direction[0]][y + direction[1]] == 0) {
                    x += direction[0];
                    y += direction[1];
                    dist++;
                }

                String newPath = path + dirSymbols[i];

                if (dist < distances[x][y] || (dist == distances[x][y] && newPath.compareTo(current.path) < 0)) {
                    distances[x][y] = dist;
                    pq.offer(new Point(x, y, dist, newPath));
                }
            }
        }

        return "impossible";
    }
}
