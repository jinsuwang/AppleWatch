package com.samjin.linkedlist;

import java.util.List;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        for(int i = 0; i < n;  i++){
            fastIndex = fastIndex.next;
        }

        while(fastIndex.next != null ){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
            if (fastIndex != null && slowIndex != null) {
                System.out.println("fastIndex is " + fastIndex.val + " slowIndex is " + slowIndex.val);
            }
        }


        if( slowIndex.next != null){
            slowIndex.next = slowIndex.next.next;
        }

        return dummyNode.next;
    }
}
