package com.samjin.tree;

import com.samjin.util.TreeNode;

public class LowestCommonAncestorOfaBinarySearchTree {
    public TreeNode<Integer> lowestCommonAncestor2(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        if(root == null) return root;

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q); // l1
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q); // l1 => p
        }else{
            return root;
        }

    }


    public TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }




}
