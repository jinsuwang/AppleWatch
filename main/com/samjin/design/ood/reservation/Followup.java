package com.samjin.design.ood.reservation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Followup {

    /**
     * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: 2
     * Example 2:
     *
     * Input: intervals = [[7,10],[2,4]]
     * Output: 1
     */


    public int canhandleReservation(int[][] reservations, int tables) {
        Arrays.sort(reservations, (int[] a, int[] b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(reservations[0][1]);

        int res = 1;

        for (int i = 1; i < reservations.length; i++) {

            while (!pq.isEmpty() && reservations[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(reservations[i][1]);

            res = Math.max(res, pq.size());

        }
        return res;
    }
}
