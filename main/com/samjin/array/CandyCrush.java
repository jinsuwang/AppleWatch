package com.samjin.array;

public class CandyCrush {

    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean stable = false;

        while (!stable) {
            stable = true;

            // Step 1: Mark candies to crush
            boolean[][] toCrush = new boolean[m][n];

            // Check rows for crushing
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int v = Math.abs(board[i][j]);
                    if (v != 0 && v == Math.abs(board[i][j + 1]) && v == Math.abs(board[i][j + 2])) {
                        toCrush[i][j] = toCrush[i][j + 1] = toCrush[i][j + 2] = true;
                        stable = false;
                    }
                }
            }

            // Check columns for crushing
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m - 2; i++) {
                    int v = Math.abs(board[i][j]);
                    if (v != 0 && v == Math.abs(board[i + 1][j]) && v == Math.abs(board[i + 2][j])) {
                        toCrush[i][j] = toCrush[i + 1][j] = toCrush[i + 2][j] = true;
                        stable = false;
                    }
                }
            }

            // Step 2: Crush candies
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toCrush[i][j]) {
                        board[i][j] = 0;
                    }
                }
            }

            // Step 3: Drop candies
            for (int j = 0; j < n; j++) {
                int write = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        board[write][j] = board[i][j];
                        write--;
                    }
                }
                for (int i = write; i >= 0; i--) {
                    board[i][j] = 0;
                }
            }
        }

        return board;
    }
}
