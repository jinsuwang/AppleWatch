package com.samjin.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization {


    public static List<List<Integer>> optUtil(int[][] a, int[][] b, int target) {
        int low = 0, high = b.length - 1, max = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        while(low < a.length && high >= 0) {
            int sum = a[low][1] + b[high][1];
            if(sum > target) {
                high--;
            } else {
                if(sum >= max) {
                    if(sum > max) {
                        max = sum;
                        res = new ArrayList<>();
                    }
                    int currHigh = high;
                    while(currHigh >= 0 && b[currHigh][1] == b[high][1]) {
                        res.add(new ArrayList<>(Arrays.asList(a[low][0], b[currHigh][0])));
                        currHigh--;
                    }
                }
                low++;
            }
        }
        return res;
    }

    public static Comparator<int[]> getComparator() {
        return (arr1, arr2) -> arr1[1] - arr2[1];
    }
}
