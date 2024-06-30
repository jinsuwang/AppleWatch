package com.samjin.tree;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                if( prev != null && (int)prev.val>= (int)node.val) return false;
                prev = node;
                root = node.right;
            }
        }
        return true;
    }

    public boolean isValidBstRecur(TreeNode root){
        return isValidBstRecurHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBstRecurHelper(TreeNode root, int minValue, int maxValue) {
        if(root == null ) return true;

        if(root.val <= minValue || root.val >= maxValue) return false;

        return isValidBstRecurHelper(root.left, minValue, root.val)
                && isValidBstRecurHelper(root.right, root.val, maxValue);

    }

    private long prev = Long.MIN_VALUE;
    public boolean isValidBSTInorder(TreeNode root){
        if (root == null) return true;
        if (!isValidBSTInorder(root.left)) return false;
        if (root.val <= prev ) return false;
        prev = root.val;
        return isValidBST(root.right);

    }
}
