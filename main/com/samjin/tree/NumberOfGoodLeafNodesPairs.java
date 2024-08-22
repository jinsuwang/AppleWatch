package com.samjin.tree;

public class NumberOfGoodLeafNodesPairs {

    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return new int[distance + 1];
        }

        // 如果是叶子节点，返回一个只有1个叶子节点的数组，表示当前节点的叶子节点距离为1
        if (node.left == null && node.right == null) {
            int[] leafCounts = new int[distance + 1];
            leafCounts[1] = 1; // 距离为1
            return leafCounts;
        }

        // 获得左子树和右子树的叶子节点距离分布
        int[] leftCounts = dfs(node.left, distance, result);
        int[] rightCounts = dfs(node.right, distance, result);

        // 计算左右子树之间的叶子节点对数，并更新结果
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                result[0] += leftCounts[i] * rightCounts[j];
            }
        }

        // 返回更新后的叶子节点距离分布
        int[] counts = new int[distance + 1];
        for (int i = 2; i <= distance; i++) {
            counts[i] = leftCounts[i - 1] + rightCounts[i - 1];
        }

        return counts;
    }
}
