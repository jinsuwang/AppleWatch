package com.samjin.array;

public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int count = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if(c == 'X') {
                    if(i >= 1 && board[i - 1][j] == 'X') continue;
                    if(j >= 1 && board[i][j - 1] == 'X') continue;
                    count++;
                }
            }
        }

        return count;
    }
}
