package com.samjin.linkedlist;

import java.util.List;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode temp1 = null;
        ListNode temp2 = null;

        while(curr.next != null && curr.next.next != null){
            temp1 = curr.next;
            temp2 = curr.next.next.next;
            curr.next = curr.next.next;
            curr.next.next = temp1;
            temp1.next = temp2;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
