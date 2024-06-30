package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) return res;

        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);

        if (root.left == null && root.right == null) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
            res.add(sb.toString());// 收集一个路径
            return;
        }

        if (root.left != null){
            traversal(root.left, paths, res);
        }
        if (root.right != null){
            traversal(root.right, paths, res);
        }

    }
}
