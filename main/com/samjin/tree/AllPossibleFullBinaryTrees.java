package com.samjin.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

    Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (cache.containsKey(n)){
            return cache.get(n);
        }

        List<TreeNode> res = new ArrayList<>();

        if (n==1){
            res.add(new TreeNode(0));
        } else if ( n % 2 == 1) {

            for (int i = 1; i < n; i+=2){
                List<TreeNode> leftTrees = allPossibleFBT(i);
                List<TreeNode> rightTrees = allPossibleFBT(n - 1 - i);

                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        cache.put(n, res);
        return res;
    }
}
