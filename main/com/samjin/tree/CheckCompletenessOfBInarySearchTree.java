package com.samjin.tree;

import com.samjin.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class CheckCompletenessOfBInarySearchTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                foundNull = true;
            } else {
                if (foundNull) {
                    // 如果已经遇到空节点，再遇到非空节点则不是完全二叉树
                    return false;
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return true;
    }
}
