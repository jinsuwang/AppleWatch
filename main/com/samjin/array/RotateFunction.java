package com.samjin.array;

/**
 * Created by sjjin on 9/6/17.
 */
public class RotateFunction {

    // Brute Force
    public int maxRotateFunction(int[] A) {
        if( A == null || A.length == 0 ) return 0;
        int maxVal = Integer.MIN_VALUE;
        for( int i = 0; i < A.length; i++ ){
            int currSum = 0;
            for( int j = 0; j < A.length; j++){
                currSum += j * A[ (i + j) % A.length ];
            }
            maxVal = Math.max(currSum,maxVal);
        }
        return maxVal;
    }
}
