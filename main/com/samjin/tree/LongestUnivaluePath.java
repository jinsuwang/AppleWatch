package com.samjin.tree;

public class LongestUnivaluePath {

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int leftPath = 0;
        int rightPath = 0;

        if(left != 0 && root.val == root.left.val) {
            leftPath = left;
        }

        if(right != 0 && root.val == root.right.val) {
            rightPath = right;
        }

        res = Math.max(res, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
}
