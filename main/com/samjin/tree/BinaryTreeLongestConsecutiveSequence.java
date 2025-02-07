package com.samjin.tree;

public class BinaryTreeLongestConsecutiveSequence {

    int res = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;

        helper(root, root.val, 0);
        return res;
    }

    private void helper(TreeNode root, int curr, int count){
        if (root == null) return;
        if (root.val == curr){
            count++;
            res = Math.max(res, count);
            helper(root.left, curr + 1, count);
            helper(root.right, curr + 1, count);
        } else {
            helper(root.left, root.val + 1, 1);
            helper(root.right, root.val + 1, 1);
        }
    }
}
