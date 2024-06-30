package com.samjin.linkedlist;

import org.junit.Test;
public class RemoveNthNodeFromEndofListTest {

    RemoveNthNodeFromEndofList t = new RemoveNthNodeFromEndofList();

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);

    public void printList(ListNode l) {
        while(l != null){
            System.out.printf(l.val + " -> ");
            l = l.next;
        }
    }

    @Test
    public void test(){

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        t.removeNthFromEnd(l1, 2);

        printList(l1);

    }
}