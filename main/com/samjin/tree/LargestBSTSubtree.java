package com.samjin.tree;

public class LargestBSTSubtree {

    class SearchNode{
        int size;
        int lower;
        int upper;

        SearchNode(int size, int lower, int upper){
            // 表示子树的大小,如果是-1表示子树不是BST
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    private SearchNode helper(TreeNode root){
        if(root == null){
            return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SearchNode left = helper(root.left);
        SearchNode right = helper(root.right);
        // 遍历到当前的节点,必须要求这个点小于右子树的最小值, 大于左子树的最大值
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower){
            return new SearchNode(-1, 0, 0);
        }

        int size = left.size + right.size + 1;
        res = Math.max(res, size);
        return new SearchNode(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return res;
    }
}
