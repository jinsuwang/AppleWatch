package com.samjin.tree;

public class LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return findLCA(root).node;
    }

    // Helper function to find LCA and depth
    private Result findLCA(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }

        Result left = findLCA(root.left);
        Result right = findLCA(root.right);

        // Compare depths of left and right
        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else {
            return new Result(right.node, right.depth + 1);
        }
    }

    // Helper class to store the node and its depth
    private static class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
