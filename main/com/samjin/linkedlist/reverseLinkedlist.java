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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // 1. 找到翻转起始点
        for(int i = 1; i < left; i++){
            prev = prev.next;
            curr = curr.next;
        }

        // 重点在prev并不移动
        for(int i = left; i < right; i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;


    }
}
