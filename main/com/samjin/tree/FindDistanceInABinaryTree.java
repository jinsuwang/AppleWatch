package com.samjin.tree;

public class FindDistanceInABinaryTree {
    public int findDistance(TreeNode root, int p, int q) {
        // 找到最近公共祖先
        TreeNode lca = findLCA(root, p, q);

        // 计算从 lca 到 p 和 q 的距离
        int distanceToP = findDepth(lca, p, 0);
        int distanceToQ = findDepth(lca, q, 0);

        // 总距离
        return distanceToP + distanceToQ;
    }

    // 辅助函数：找到最近公共祖先 (LCA)
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root; // 如果 p 和 q 分别在左右子树，当前节点是 LCA
        }
        return left != null ? left : right; // 否则在一侧的子树中
    }

    // 辅助函数：计算从 root 到目标节点的深度
    private int findDepth(TreeNode root, int target, int depth) {
        if (root == null) {
            return -1; // 找不到目标节点
        }
        if (root.val == target) {
            return depth;
        }
        int left = findDepth(root.left, target, depth + 1);
        if (left != -1) {
            return left; // 如果在左子树找到，返回结果
        }
        return findDepth(root.right, target, depth + 1); // 否则继续在右子树寻找
    }
}
