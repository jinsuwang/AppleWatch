package com.samjin.sortandsearch;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while( i < matrix.length && j >=0 ){
            int curr = matrix[i][j];
            if(curr == target) return true;
            if(curr < target) i++;
            else j--;
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while( i < matrix.length && j >=0 ){
            int curr = matrix[i][j];
            if(curr == target) return true;
            if(curr < target) i++;
            else j--;
        }
        return false;
    }
}
