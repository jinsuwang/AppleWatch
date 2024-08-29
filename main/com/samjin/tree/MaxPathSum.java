package com.samjin.tree;

public class MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right children
        int leftMax = Math.max(traverse(node.left), 0);
        int rightMax = Math.max(traverse(node.right), 0);

        // Calculate the maximum path sum passing through the current node
        int currentPathSum = node.val + leftMax + rightMax;

        // Update the global maximum sum if the current path sum is larger
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum path sum including the current node and either left or right child
        return node.val + Math.max(leftMax, rightMax);
    }
}
