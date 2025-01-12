package com.samjin.sortandsearch;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortredArray {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0; // 三个指针

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // 如果当前指针指向的值相等
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                // 找到当前最小值，让对应的指针向前移动
                int minVal = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if (arr1[i] == minVal) i++;
                if (arr2[j] == minVal) j++;
                if (arr3[k] == minVal) k++;
            }
        }

        return result;
    }
}
