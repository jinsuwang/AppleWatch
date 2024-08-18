package com.samjin.linkedlist;

import org.w3c.dom.Node;

public class InsertIntoASortedCircularLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (true) {
            if (curr.val <= insertVal && insertVal <= curr.next.val) {
                // Case 1: insertVal fits between two nodes.
                break;
            }
            if (curr.val > curr.next.val) {
                // Case 2: We are at the "end" of the sorted list,
                // where max value is followed by the min value.
                if (insertVal >= curr.val || insertVal <= curr.next.val) {
                    break;
                }
            }
            curr = curr.next;
            // If we looped all the way back to the start   if (head == null) {
            //            Node newNode = new Node(insertVal);
            //            newNode.next = newNode;
            //            return newNode;
            //        }
            //
            //        Node curr = head;
            //        while (true) {
            //            if (curr.val <= insertVal && insertVal <= curr.next.val) {
            //                // Case 1: insertVal fits between two nodes.
            //                break;
            //            }
            //            if (curr.val > curr.next.val) {
            //                // Case 2: We are at the "end" of the sorted list,
            //                // where max value is followed by the min value.
            //                if (insertVal >= curr.val || insertVal <= curr.next.val) {
            //                    break;
            //                }
            //            }
            //            curr = curr.next;
            //            // If we looped all the way back to the start, insert at the end
            //            if (curr == head) {
            //                break;
            //            }
            //        }
            //
            //        // Insert the new node
            //        Node newNode = new Node(insertVal);
            //        newNode.next = curr.next;
            //        curr.next = newNode;
            //        return head;, insert at the end
            if (curr == head) {
                break;
            }
        }

        // Insert the new node
        Node newNode = new Node(insertVal);
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}
