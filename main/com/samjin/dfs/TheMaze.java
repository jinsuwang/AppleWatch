package com.samjin.dfs;

import java.util.Arrays;

public class TheMaze {

    static int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }

    private static boolean dfs(int[][] maze, int[] curr, int[] dest, boolean[][] visited) {

        if(curr[0] == dest[0] && curr[1] == dest[1]) {
            return true;
        };

        if(visited[curr[0]][curr[1]]) return false;

        visited[curr[0]][curr[1]] = true;

        for(int[] dir : dirs) {
            int x = curr[0];
            int y = curr[1];

            while(x + dir[0] >= 0 &&
                    x + dir[0] < maze.length &&
                    y + dir[1] >= 0 &&
                    y + dir[1] < maze[0].length &&
                    maze[x + dir[0]][y + dir[1]] != 1) {
                x += dir[0];
                y += dir[1];
            }

            if(dfs(maze, new int[]{x, y}, dest, visited)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        System.out.println(hasPath(maze, new int[]{0,4}, new int[]{3,2}));
    }
}
