package com.samjin.dfs;

public class MineSweeper {

    private static final int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        // 如果点击的是地雷，则直接变成 'X'
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        // 启动 DFS 递归搜索
        dfs(board, row, col);
        return board;
    }


    // 深度优先搜索函数
    private void dfs(char[][] board, int row, int col) {
        // 如果这个位置不是未挖掘的空方块，直接返回
        if (board[row][col] != 'E') {
            return;
        }

        // 统计当前位置周围的地雷数量
        int mineCount = countMines(board, row, col);

        if (mineCount > 0) {
            // 如果周围有地雷，更新当前方块为地雷数量
            board[row][col] = (char) (mineCount + '0');
        } else {
            // 如果周围没有地雷，标记为 'B'，并递归揭露周围的空方块
            board[row][col] = 'B';
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValid(board, newRow, newCol)) {
                    dfs(board, newRow, newCol);
                }
            }
        }
    }

    private int countMines(char[][] board, int row, int col) {
        int count = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValid(board, newRow, newCol) && board[newRow][newCol] == 'M') {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
