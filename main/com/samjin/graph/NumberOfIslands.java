package com.samjin.graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int ROW = grid.length;
        int COL = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++){
            for (int j =0; j < COL; j++){
                if (grid [i][j] == '1'){
                    count += dfs(grid, i, j, visited);;
                }
            }
        }
        return count;

    }

    private int dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i<0 || i >= grid.length || j<0 ||j>= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return 0 ;
        }

        visited[i][j] = true; // mark as visited
        dfs(grid, i + 1, j, visited); // down
        dfs(grid,  i - 1, j, visited); // up
        dfs(grid,  i, j + 1, visited); // right
        dfs(grid,  i, j - 1, visited); // left
        return 1;
    }
}
