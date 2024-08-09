package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    List<Integer> res = new ArrayList<>();
    Integer maxlevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int currLevel) {
        if(root == null) return;
        if(currLevel > maxlevel){
            maxlevel = currLevel;
            res.add((Integer)root.val);
        }
        dfs(root.right, currLevel+1);
        dfs(root.left, currLevel+1);
    }
}
