package com.samjin.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingRooms2Test {

    MeetingRooms2 ins = new MeetingRooms2();

    @Test
    public void minMeetingRooms() {

        int[][] test = new int[7][2];

        test[0] = new int[]{5, 10};
        test[1] = new int[]{5, 10};
        test[2] = new int[]{5, 10};
        test[3] = new int[]{11, 12};
        test[4] = new int[]{13, 14};
        test[5] = new int[]{15, 16};
        test[6] = new int[]{17, 18};


        System.out.println(ins.minMeetingRooms(test));
    }
}