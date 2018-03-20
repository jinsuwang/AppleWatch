package com.samjin.linkedlist;

import com.samjin.util.ListNode;
import com.samjin.util.MyPrinter;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head == null) return false;
        if(head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;


        // 1 -> 2 -> 3 -> 2 -> 1
        // 1 -> 2 -> 2 -> 1
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        while(mid.next != null){
            ListNode tmp = mid.next;
            mid.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }

        slow = slow.next;
        while(slow != null){
            if(slow.val != head.val){ return false;}
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
