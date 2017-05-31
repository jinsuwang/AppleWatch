package com.samjin.linkedlist;

import com.samjin.util.ListNode;

/**
 * Created by sjjin on 5/30/17.
 */
public class FindMidPointLinkedList {

    public static int findMidPointLinkedList(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

}
