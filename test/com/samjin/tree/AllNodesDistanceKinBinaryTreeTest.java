package com.samjin.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllNodesDistanceKinBinaryTreeTest {

    TreeNode node3 = new TreeNode(3);
    TreeNode node5 = new TreeNode(5);
    TreeNode node1 = new TreeNode(1);

    TreeNode node2 = new TreeNode(2);

    TreeNode node6 = new TreeNode(6);
    TreeNode node0 = new TreeNode(0);
    TreeNode node8 = new TreeNode(8);

    TreeNode node4 = new TreeNode(4);
    TreeNode node7 = new TreeNode(7);


    public AllNodesDistanceKinBinaryTreeTest(){
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
    }

    @Test
    public void distanceK() {

        AllNodesDistanceKinBinaryTree ins = new AllNodesDistanceKinBinaryTree();
        ins.distanceK(node3, node5, 2);
    }
}