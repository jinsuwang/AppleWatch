package com.samjin.tree;

import com.samjin.linkedlist.ListNode;

import java.util.*;

public class BinaryTreeTraversal {
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

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while( !stack.isEmpty() ){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null ){
                stack.push(node.right);
            }
            if (node.left != null ){
                stack.push(node.left);
            }
        }

        return res;
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while( curr != null &&  !stack.isEmpty() ){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }


    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while( !stack.isEmpty() ){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }

        Collections.reverse(res);
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while(len > 0){
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);

                if(tmpNode.left != null) queue.offer(tmpNode.left);
                if(tmpNode.right != null) queue.offer(tmpNode.right);
                len--;
            }

            res.add(itemList);
        }

        return res;
    }

}