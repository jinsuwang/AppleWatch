package com.samjin.algorithm;


/**
 * 回溯法：
 *
 * http://blog.csdn.net/u011956147/article/details/68066304
 * https://segmentfault.com/a/1190000006121957
 *
 */
public class BackTracking {

    int n = 10;

    public void recursiveFramework(int i){

        if(i > n){ // out of boundary
            return;
        }

        for (int j = i; j < n; i++){
            if(valid(j)){
                recursiveFramework(i+1);
            }
            // clean work for backtracking.
        }
    }

    private boolean valid(int j) {
        return true;
    }
}
