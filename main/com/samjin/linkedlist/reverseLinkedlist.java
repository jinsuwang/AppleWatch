package com.samjin.linkedlist;

import com.samjin.util.ListNode;

public class reverseLinkedlist {

    public ListNode reverseList(ListNode head) {

        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
