package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();

        helper(root, sum, new ArrayList<>());

        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                // 清除这个path
                temp.remove(temp.size() - 1);
            }

            return;
        }

        temp.add(root.val);
        helper(root.left, sum - root.val, temp);
        helper(root.right, sum - root.val, temp);
        temp.remove(temp.size() - 1);
    }
}