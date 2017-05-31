package com.samjin.util;

/**
 * Created by sjjin on 5/29/17.
 */
public class TestFactory {


    /**
     * @return
     *       4
     *    2    6
     *  1  3  5  7
     */
    public static TreeNode getTestIntegerBST(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        n4.left = n2;
        n4.right = n6;

        return n4;
    }


    public static ListNode getNormalLinkedlist(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5; l5.next = l6; l6.next = l7;
        return l1;
    }
}
