package com.samjin.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) return head;


        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;

        while (head != null) {
            if (map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }

            pre.next = newNode;

            // handle new node
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            // move to next one
            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode curr = head;

        while(curr!= null){
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }

        curr = head;

        while(curr!=null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);

    }
}