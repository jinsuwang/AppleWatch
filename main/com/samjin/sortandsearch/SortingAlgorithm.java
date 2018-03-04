package com.samjin.sortandsearch;

import java.util.Arrays;

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

    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length - 1 );
    }

    private static void quickSortHelper(int[] arr, int start, int end) {
        if( start >= end ) return;
//        Random ran = new Random();
//        int pIndex = ran.nextInt(end - start + 1) + start;
        int pIndex = start + (end - start)/2;
        int pivot = arr[pIndex];

        System.out.println("pIndex: " + pIndex + " pivot: " + pivot + " " + Arrays.toString(arr));

        int left = start;
        int right = end;

        while(left <= right){
            while(left <= right && arr[left] < pivot) left++;
            while(left <= right && arr[right] > pivot ) right--;

            // time to swap
            if(left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }

        }
        quickSortHelper(arr, start, right);
        quickSortHelper(arr, left, end);
    }

}