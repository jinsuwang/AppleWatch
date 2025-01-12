package com.samjin.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> BinaryTreeZigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean left2right = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(left2right == true){
                    level.add(curr.val);
                } else{
                    level.add(0, curr.val);
                }

                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }

            res.add(level);
            left2right = !left2right;
        }

        return res;
    }
}
