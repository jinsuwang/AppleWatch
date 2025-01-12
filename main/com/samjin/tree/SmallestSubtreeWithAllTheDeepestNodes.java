package com.samjin.tree;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // 定义一个辅助类，返回当前子树的深度和最小子树的根节点
    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(null, 0); // 空节点深度为 0，根节点为 null
        }

        // 递归计算左子树和右子树的结果
        Result left = dfs(node.left);
        Result right = dfs(node.right);

        // 如果左右子树深度相同，当前节点是最小子树的根节点
        if (left.depth == right.depth) {
            return new Result(node, left.depth + 1);
        }

        // 如果左子树更深，返回左子树的结果
        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }

        // 否则返回右子树的结果
        return new Result(right.node, right.depth + 1);
    }

    // 辅助类，包含最小子树的根节点和子树深度
    private static class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
