package com.samjin.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        // 递归函数
        helper(root, toDeleteSet, forest);

        // 如果根节点不被删除，加入结果森林
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        // 递归处理左右子树
        node.left = helper(node.left, toDeleteSet, forest);
        node.right = helper(node.right, toDeleteSet, forest);

        // 当前节点是否需要删除
        if (toDeleteSet.contains(node.val)) {
            // 将非空的左右子树加入森林
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null; // 删除当前节点
        }

        return node; // 保留当前节点
    }
}
