package com.samjin.tree;

import com.samjin.util.TreeNode;

import java.util.*;

/**
 * Created by sjjin on 9/9/17.
 */
public class TreeTraversal {

    public String inorderTraveralRecur(TreeNode root){

        StringBuilder sb = new StringBuilder();
        inorderTraversalRecurHelper(root, sb);
        return sb.toString();
    }

    private void inorderTraversalRecurHelper(TreeNode root, StringBuilder sb){
        if(root == null) return;
        inorderTraversalRecurHelper(root.left, sb);
        sb.append(root.val);
        inorderTraversalRecurHelper(root.right, sb);
    }

    public String inorderTraversalIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() || root != null ){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                sb.append(node.val);
                root = node.right;
            }
        }
        return sb.toString();
    }

    public String preorderTraveralRecur(TreeNode root){
        StringBuilder sb = new StringBuilder();
        preorderTraveralRecurHelper(root, sb);
        return sb.toString();
    }

    private void preorderTraveralRecurHelper(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val);
        preorderTraveralRecurHelper(root.left,sb);
        preorderTraveralRecurHelper(root.right,sb);
    }

    public String preorderTraversalIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                sb.append(root.val);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return sb.toString();
    }

    public String postorderTraversalRecur(TreeNode root){
        return null;
    }

    public String postorderTraversalIter(TreeNode root){
        return null;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);

        while(!curr.isEmpty()){

            List<Integer> level = new ArrayList<>();
            int size = curr.size();

            for(int i = 0; i < size; i++ ){
                TreeNode node = curr.poll();
                level.add((Integer)node.val);
                if(node.left != null) curr.add(node.left);
                if(node.right != null) curr.add(node.right);
            }

            res.add(level);
        }
        return res;
    }

}
