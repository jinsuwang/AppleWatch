package com.samjin.tree;

public class MinimumAbsoluteDifferenceInBST {


    int res = Integer.MAX_VALUE;

    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        if (prev != null){
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;

        traverse(root.right);
    }
}
