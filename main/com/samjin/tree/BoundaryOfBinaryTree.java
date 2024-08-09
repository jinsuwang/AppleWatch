package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null ) return res;

        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        res.add(root.val);

        getLeft(root.left);
        getBottom(root);
        getRight(root.right);

        return res;
    }

    private void getLeft(TreeNode root) {
        if ( root == null ) return;

        if (root.left == null && root.right == null) return;

        res.add(root.val);

        if (root.left != null ){
            getLeft(root.left);
        } else {
            getLeft(root.right);
        }
    }

    private void getBottom(TreeNode root) {

        if (root == null) return;
        getBottom(root.left);
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        getBottom(root.right);

    }

    private void getRight(TreeNode root) {
        if ( root == null ) return;

        if (root.left == null && root.right == null) return;

        if (root.right != null ){
            getRight(root.right);
        } else {
            getRight(root.left);
        }
        res.add(root.val);
    }

}
