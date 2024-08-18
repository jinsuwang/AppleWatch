package com.samjin.dfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheMaze2 {

    private static class Point {
        int x, y, dist;
        Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        // Distance array to track the shortest distance to each cell
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        // Priority queue to pick the point with the shortest distance
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Point(start[0], start[1], 0));

        // Possible directions to move: right, left, down, up
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            Point current = pq.poll();

            // If we've reached the destination, return the distance
            if (current.x == destination[0] && current.y == destination[1]) {
                return current.dist;
            }

            // Explore all possible directions
            for (int[] direction : directions) {
                int x = current.x;
                int y = current.y;
                int dist = current.dist;

                // Roll the ball until it hits a wall or the boundary
                while (x + direction[0] >= 0 && x + direction[0] < m
                        && y + direction[1] >= 0 && y + direction[1] < n
                        && maze[x + direction[0]][y + direction[1]] == 0) {
                    x += direction[0];
                    y += direction[1];
                    dist++;
                }

                // If the new distance is shorter, update and add to the queue
                if (dist < distance[x][y]) {
                    distance[x][y] = dist;
                    pq.offer(new Point(x, y, dist));
                }
            }
        }

        // If the destination is unreachable, return -1
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

}
