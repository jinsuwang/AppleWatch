package com.samjin.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sjjin on 5/29/17.
 */
public class MyPrinter {

    public static void printLinkedlist(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void printTreeLevelOrder(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            res.add((Integer)tmp.val);
            if( tmp.left != null )  queue.offer(tmp.left);
            if( tmp.right != null ) queue.offer(tmp.right);
        }

        System.out.println(res.toString());
    }
}
