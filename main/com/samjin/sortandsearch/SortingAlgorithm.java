package com.samjin.sortandsearch;

import java.util.Random;

/**
 * Created by sjjin on 12/11/17.
 */
public class SortingAlgorithm {

    public static int[] bubbleSort(int[] arr){
        return null;
    }

    public static int[] mergeSort(int[] arr){
        return null;
    }

    public static void quickSort(int[] A){
        quickSortHelper(A, 0, A.length - 1);
    }

    private static void quickSortHelper(int[] A, int start, int end) {

        if( start >= end ) return;

        Random random = new Random();

        // int value between 0 (inclusive) and n (exclusive).
        int pIndex = random.nextInt( end - start + 1 ) + start;
        int pivot = A[pIndex];

        int left = start;
        int right = end;

        while( left <= right ){
            while( left <= right && A[left] < pivot ) left++ ;
            while( left <= right && A[right] > pivot ) right--;

            // Swap
            if( left <= right ){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;

                left++; right--;
            }
        }

        quickSortHelper(A, start, right);
        quickSortHelper(A, left, end);
    }

}
