package com.samjin.tree;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            // If the current value is closer to the target, update closest
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }

            // Move to the left or right subtree depending on the target
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
}
