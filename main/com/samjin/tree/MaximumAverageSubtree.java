package com.samjin.tree;

public class MaximumAverageSubtree {

    private double average = 0;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return average;
    }

    private int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int number = left + right + 1;
        if(left != 0)
            root.val += root.left.val;
        if(right != 0)
            root.val += root.right.val;
        average = Math.max(average, (double)(root.val) / number);
        return number;
    }
}
