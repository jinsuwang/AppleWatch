package com.samjin.linkedlist;

import java.util.List;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        for (int i = 0; i<n; i++){
            head = head.next;
        }

        while(head != null){
            head = head.next;
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = curr.next;

        return dummy.next;
    }
}
