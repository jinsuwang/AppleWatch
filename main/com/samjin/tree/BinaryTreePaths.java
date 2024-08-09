package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;

        helper(res, root, "");
        return res;
    }

    private void helper(List<String> res, TreeNode root, String curr) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(curr + root.val);
            return;
        }

        helper(res, root.left, curr + root.val + "->");
        helper(res, root.right, curr + root.val + "->");
    }
}
