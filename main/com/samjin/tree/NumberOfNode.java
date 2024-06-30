package com.samjin.tree;

public class NumberOfNode {

    public int countNodes(TreeNode root) {

        if (root == null) return 0;

        int leftNode = countNodes(root.left);
        int rightNode = countNodes(root.right);

        return leftNode + rightNode + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftDepth = 0, rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        while (right != null){
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth){
            return (2<<leftDepth) - 1;
        }

        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
