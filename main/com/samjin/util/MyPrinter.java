package com.samjin.util;

/**
 * Created by sjjin on 5/29/17.
 */
public class MyPrinter {

    public static void printLinkedlist(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
