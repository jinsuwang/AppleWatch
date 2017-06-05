package com.samjin.util;

import org.junit.Test;

import java.util.List;

/**
 * Created by sjjin on 5/29/17.
 */
public class TestFactoryTest {
    @Test
    public void getTestIntegerBST() throws Exception {
        TreeNode root = TestFactory.getTestIntegerBST();
        TraversalHelper.preorderTraversalRecur(root);
        System.out.println();

        List<Integer> preorderList = TraversalHelper.preorderTraversalIter(root);
        System.out.println(preorderList);

        TraversalHelper.inorderTraversalRecur(root);
        System.out.println();

        List<Integer> inorderList = new TraversalHelper().inorderTraversalIter(root);
        System.out.println(inorderList);

        System.out.println();
        TraversalHelper.postorderTraversalRecur(root);
    }


    @Test
    public void testGetNormalLinkedlist(){
        ListNode head = TestFactory.getNormalLinkedlist();
        MyPrinter.printLinkedlist(head);
    }
}