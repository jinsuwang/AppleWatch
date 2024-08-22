package com.samjin.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodes {

    public ListNode removeZeroSumSublists(ListNode head) {

        // 创建一个虚拟头节点，方便处理边界情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 用于存储前缀和及其对应的节点
        HashMap<Integer, ListNode> prefixSumMap = new HashMap<>();
        int sum = 0;

        // 第一次遍历，记录每个前缀和最后一次出现的节点
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            prefixSumMap.put(sum, node);
        }

        // 第二次遍历，删除所有和为零的子链表
        sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            // 将当前节点的 next 指向该前缀和最后一次出现的节点的 next
            node.next = prefixSumMap.get(sum).next;
        }

        return dummy.next;


    }
}
