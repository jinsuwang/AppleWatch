package com.samjin.tree;

public class RangeSumofBST {

    int res = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return res;
        helper(root, L, R);
        return res;
    }

    private void helper(TreeNode root, int L, int R) {
        if (root == null)
            return;
        if (root.val < L) {
            helper(root.right, L, R);
        } else if (root.val > R) {
            helper(root.left, L, R);
        } else {
            res += root.val;
            helper(root.left, L, R);
            helper(root.right, L, R);
        }
    }
}
