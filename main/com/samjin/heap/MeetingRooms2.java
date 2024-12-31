package com.samjin.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {

//        Timestamp timestamp1 = Timestamp.valueOf("2023-10-10 10:10:10.123456789");
//        Timestamp timestamp2 = Timestamp.valueOf("2023-10-10 10:10:10.123456000");
//
//        int result = timestamp1.compareTo(timestamp2);
//
//        if (result == 0) {
//            System.out.println("The two timestamps are equal.");
//        } else if (result > 0) {
//            System.out.println("Timestamp1 is later than Timestamp2.");
//        } else {
//            System.out.println("Timestamp1 is earlier than Timestamp2.");
//        }

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
