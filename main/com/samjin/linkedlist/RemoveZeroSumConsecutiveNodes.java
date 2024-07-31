package com.samjin.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodes {

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        int prefixSum = 0;

        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();

        for (ListNode current = dummy; current != null; current = current.next) {
            prefixSum += curr.val;
            if (prefixSumToNode.containsKey(prefixSum)){
                ListNode prev = prefixSumToNode.get(prefixSum);
                ListNode toRemove = prev.next;

                int p = prefixSum + (toRemove != null ? toRemove.val : 0);
                while (p != prefixSum) {
                    prefixSumToNode.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }

                prev.next = curr.next;
            }else{
                prefixSumToNode.put(prefixSum, curr);
            }
        }

        return dummy.next;


    }
}
