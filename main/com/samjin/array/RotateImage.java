package com.samjin.array;

public class RotateImage {

    public void rotate(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return;

        int len = matrix.length;
        int tmp;

        for( int i = 0; i < len / 2; i++ ){
            for( int j = 0; j < (len+1) / 2; j++ ){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }
}
