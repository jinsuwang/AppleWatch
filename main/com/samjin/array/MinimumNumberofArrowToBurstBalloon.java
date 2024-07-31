package com.samjin.array;

import java.util.Arrays;
public class MinimumNumberofArrowToBurstBalloon {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            // 不能使用 a[0] - b[0]
            // 数字太大会造成overflow
            // [[-2147483646,-2147483645],[2147483646,2147483647]]
            if (a[0] == b[0]) return 0;
            if (a[0] < b[0]) return -1;
            return 1;
        });

        int res = 1;
        int[] start = points[0];

        for(int i = 1; i < points.length; i++) {
            int[] curr = points[i];

            if(curr[0] > start[1]) {
                res++;
                start = curr;
            } else {
                start[0] = Math.max(start[0], curr[0]);
                start[1] = Math.min(start[1], curr[1]);
            }
        }

        return res;
    }
}
