package com.samjin.sortandsearch;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] head = intervals[0];
        int res = 0;

        for(int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if(curr[0] < head[1]) {
                res++;
                head[1] = Math.min(head[1], curr[1]); // [[1,11],[2,100],[3,12],[11,22]]
            } else {
                head = curr;
            }
        }

        return res;
    }
}
