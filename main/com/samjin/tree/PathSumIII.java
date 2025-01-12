package com.samjin.tree;

import java.util.HashMap;

public class PathSumIII {

    int res = 0;
    int targetSum;
    HashMap<Long, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap();
        this.targetSum = targetSum;
        help(root, 0);

        return res;
    }

    public void help(TreeNode node, long currSum) {
        if (node == null) return;

        currSum += node.val;

        if (currSum == targetSum) res++;

        res += map.getOrDefault(currSum - targetSum, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        help(node.left, currSum);
        help(node.right, currSum);

        map.put(currSum, map.get(currSum) - 1);
    }

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return (int)help2(root, (long)targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private long help2(TreeNode node, long targetSum) {
        if (node == null) return 0;

        return (node.val == targetSum ? 1 : 0)
                + help2(node.left, targetSum - node.val)
                + help2(node.right, targetSum - node.val);
    }
}
