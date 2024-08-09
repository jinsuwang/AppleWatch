package com.samjin.linkedlist;

import org.junit.Test;
import com.samjin.util.ListNode;
import static org.junit.Assert.*;

public class reverseLinkedlistTest {


    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    @Test
    public void reverseBetween() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        printList(node1);

        reverseLinkedlist ins = new reverseLinkedlist();

        ins.reverseBetween(node1, 2,4);

        printList(node1);

    }
}