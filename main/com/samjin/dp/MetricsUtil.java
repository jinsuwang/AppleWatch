package com.samjin.dp;

public class MetricsUtil {

    public static void print(int[][] metrics){
        for (int[] row : metrics) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
