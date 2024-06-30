package com.samjin.tree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return compareRecurHelper(root.left, root.right);
    }

    private boolean compareRecurHelper(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val ) return false;
        return compareRecurHelper(left.left, right.right) && compareRecurHelper(left.right, right.left);
    }
}
