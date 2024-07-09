package com.samjin.linkedlist;

import com.samjin.util.ListNode;

public class reverseLinkedlist {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;
        ListNode tmp = null;

        while( curr != null ){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }
}
