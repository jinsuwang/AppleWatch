package com.samjin.tree;

import com.samjin.util.TreeNode;

import java.util.Arrays;
import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int res = (int)curr.val;
        if(curr.right != null){
            curr = curr.right;
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
}
