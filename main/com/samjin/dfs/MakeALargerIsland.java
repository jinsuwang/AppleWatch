package com.samjin.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeALargerIsland {

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int largestIsland(int[][] grid) {
        // color: size
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int n = grid.length;
        int colorIndex = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = paint(grid, i, j, colorIndex);
                    map.put(colorIndex, size);
                    colorIndex++;
                }
            }
        }

        // give first color size
        int res = map.getOrDefault(2, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 可以变成1
                if (grid[i][j] == 0) {
                    // 找是否有相邻的island
                    // 还要防止使用重复的color
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n)
                            continue;

                        set.add(grid[x][y]);
                    }

                    int sizeSum = 1;
                    for (int color : set) {
                        sizeSum += map.get(color);
                    }

                    res = Math.max(res, sizeSum);
                }
            }
        }

        return res;
    }

    private int paint(int[][] grid, int i, int j, int color) {
        if (i < 0 ||
                j < 0 ||
                i >= grid.length ||
                j >= grid[0].length ||
                grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = color;
        return 1 +
                paint(grid, i + 1, j, color) +
                paint(grid, i - 1, j, color) +
                paint(grid, i, j + 1, color) +
                paint(grid, i, j - 1, color);
    }
}
