package com.samjin.linkedlist;

import java.util.List;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        ListNode curr = head;

        while(curr.next != null && curr.next.next != null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = head.next.next.next;

            curr.next = curr.next.next;
            curr.next.next = tmp1;
            tmp1.next = tmp2;
        }
        return dummy.next;
    }
}
