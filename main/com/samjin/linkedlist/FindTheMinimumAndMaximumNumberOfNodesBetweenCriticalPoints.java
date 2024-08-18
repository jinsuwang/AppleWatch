package com.samjin.linkedlist;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCP = -1, lastCP = -1;
        int minDist = Integer.MAX_VALUE;
        int index = 0, prevCP = -1;
        ListNode prev = head, curr = head.next;

        while (curr != null && curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val)) {
                if (firstCP == -1) {
                    firstCP = index;
                } else {
                    minDist = Math.min(minDist, index - prevCP);
                }
                prevCP = index;
                lastCP = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstCP == lastCP) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, lastCP - firstCP};
    }
}
