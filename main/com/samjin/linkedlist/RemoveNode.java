package com.samjin.linkedlist;



public class RemoveNode {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null){
            if (curr.val == val){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}


