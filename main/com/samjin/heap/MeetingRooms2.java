package com.samjin.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);

        int res = 1;

        for (int i = 1; i < intervals.length; i++) {

            while (!pq.isEmpty() && intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i][1]);

            res = Math.max(res, pq.size());

        }
        return res;

    }
}
