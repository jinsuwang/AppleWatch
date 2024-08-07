package com.samjin.linkedlist;

import com.samjin.util.ListNode;

/**
 * Created by sjjin on 8/25/17.
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
