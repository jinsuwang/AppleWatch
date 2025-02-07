package com.samjin.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodePathOfBInaryTree {

    // 1. 找 LCA（最近公共祖先）
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 2. DFS 查找 root 到 target 的路径
    public static boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;

        path.add(root); // 添加当前节点

        if (root == target) return true;

        // 递归寻找路径
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1); // 回溯
        return false;
    }

    // 3. 计算从 p 到 q 的完整路径
    public static List<Integer> findPathBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);

        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        findPath(lca, p, pathP); // LCA -> p
        findPath(lca, q, pathQ); // LCA -> q

        Collections.reverse(pathQ); // 反转 pathQ，使其从 LCA 到 q

        List<Integer> result = new ArrayList<>();
        for (TreeNode node : pathP) result.add(node.val);
        for (int i = 1; i < pathQ.size(); i++) result.add(pathQ.get(i).val); // 避免 LCA 重复

        return result;
    }
}
