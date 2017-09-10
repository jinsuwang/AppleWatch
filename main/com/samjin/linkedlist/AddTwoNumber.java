package com.samjin.linkedlist;

import com.samjin.util.ListNode;

/**
 * Created by sjjin on 8/25/17.
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int tmp = 0;
        int curr = 0;
        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;

        while(l1 != null && l2 != null){
            int val = (l1.val + l2.val + tmp);


            curr = val % 10;
            tmp = val / 10;

            currNode.next = new ListNode(curr);
            currNode = currNode.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        while(l1 != null){
            int val = l1.val + tmp;
            curr = val % 10;
            tmp = val / 10;

            currNode.next = new ListNode(curr);
            currNode = currNode.next;
            l1.next = l1;
        }

        while(l2 != null){
            int val = l2.val + tmp;
            curr = val % 10;
            tmp = val / 10;

            currNode.next = new ListNode(curr);
            currNode = currNode.next;
            l2.next = l2;
        }
        return dummy.next;
    }
}
