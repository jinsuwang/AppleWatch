package com.samjin.array;

class TicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        // Update the row and column
        rows[row] += toAdd;
        cols[col] += toAdd;

        // Update the diagonal
        if (row == col) {
            diagonal += toAdd;
        }

        // Update the anti-diagonal
        if (row + col == n - 1) {
            antiDiagonal += toAdd;
        }

        // Check if the current player has won
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }

        // No one has won
        return 0;
    }
}
