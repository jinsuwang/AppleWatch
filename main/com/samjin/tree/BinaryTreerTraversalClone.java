package com.samjin.tree;

import com.samjin.array.TrappingRainWater;

import java.util.*;

public class BinaryTreerTraversalClone {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalHelper(res, root);
        return res;
    }

    private void preorderTraversalHelper(List<Integer> res, TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        preorderTraversalHelper(res, node.left);
        preorderTraversalHelper(res, node.right);
    }

    public List<Integer> preorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
//                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while( !queue.isEmpty() ){
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode curr = queue.poll();
                tmp.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null ) queue.offer(curr.right);
                size--;
            }
            res.add(tmp);
        }
        return res;
    }
}
