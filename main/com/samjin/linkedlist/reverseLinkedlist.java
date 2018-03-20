package com.samjin.linkedlist;

import com.samjin.util.ListNode;

public class reverseLinkedlist {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        // from dummy -> n1 -> n2 -> n3
        // to  dummy -> n2 -> n1 -> n3
        while(curr.next != null){
            ListNode tmp = curr.next; // tmp = n3
            curr.next = tmp.next; // n1.next = null;
            tmp.next = dummy.next; // n3.next = n2;
            dummy.next = tmp; // dummy.next = n3;
        }
        return dummy.next;
    }
}
