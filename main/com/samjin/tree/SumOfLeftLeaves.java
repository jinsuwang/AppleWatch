package com.samjin.tree;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) return 0;

        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res = root.left.val;
        }
        int sum = res + leftValue + rightValue;
        return sum;
    }
}
