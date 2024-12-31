package com.samjin.tree;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEvenLevel = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prevValue = isEvenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int value = node.val;

                // Check if the current level is even
                if (isEvenLevel) {
                    // Values must be odd and strictly increasing
                    if (value % 2 == 0 || value <= prevValue) {
                        return false;
                    }
                } else {
                    // Values must be even and strictly decreasing
                    if (value % 2 != 0 || value >= prevValue) {
                        return false;
                    }
                }

                prevValue = value;

                // Add child nodes to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Toggle the level type
            isEvenLevel = !isEvenLevel;
        }

        return true;
    }
}
