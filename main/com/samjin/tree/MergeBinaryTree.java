package com.samjin.tree;

/**
 * Created by sjjin on 9/10/17.
 */
public class MergeBinaryTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if( t1 == null && t2 == null ) return null;

        int val = (t1 == null ? 0 : (int)t1.val) + (t2 == null ? 0 : (int)t2.val);

        TreeNode node = new TreeNode(val);

        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return node;
    }
}
