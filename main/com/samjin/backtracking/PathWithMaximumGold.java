package com.samjin.backtracking;

import java.util.HashSet;
import java.util.Set;

public class PathWithMaximumGold {

    int res = 0;
    public int getMaximumGold(int[][] grid) {

        if (grid == null) return 0;

        int row = grid.length, col = grid[0].length;

        Set<String> visited = new HashSet<>();
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != 0){
                    dfs(grid, i, j, 0, visited);
                }
            }
        }

        return res;

    }

    public void dfs(int[][] grid, int i, int j, int tmp, Set<String> visited){
        if( i<0 || j < 0 || i >= grid.length || j >= grid[0].length || visited.contains(i+","+j) || grid[i][j] == 0) {
            res = Math.max(res, tmp);
            return;
        }
        visited.add(i+","+j);

        dfs(grid, i + 1, j, tmp + grid[i][j], visited);
        dfs(grid, i, j+1,  tmp + grid[i][j], visited);
        dfs(grid, i - 1, j, tmp + grid[i][j], visited);
        dfs(grid, i , j-1, tmp + grid[i][j], visited);

        visited.remove(i+","+j);

    }
}
