package com.samjin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sjjin on 5/29/17.
 */
public class TraversalHelper {

    public static void preorderTraversalRecur(TreeNode root){
        if(root == null) return;
        System.out.print(root.val  + " ");
        preorderTraversalRecur(root.left);
        preorderTraversalRecur(root.right);
    }

    public static void inorderTraversalRecur(TreeNode root){
        if(root == null) return;
        inorderTraversalRecur(root.left);
        System.out.print(root.val  + " ");
        inorderTraversalRecur(root.right);
    }

    public static void postorderTraversalRecur(TreeNode root){
        if(root == null) return;
        postorderTraversalRecur(root.left);
        postorderTraversalRecur(root.right);
        System.out.print(root.val  + " ");
    }


    public static List<Integer> inorderTraversalIter(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( !stack.isEmpty() || root != null ){
            if( root != null ){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode curr = stack.pop();
                res.add((Integer)curr.val);
                root = curr.right;
            }
        }
        return res;
    }


    public static List<Integer> preorderTraversalIter(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( !stack.isEmpty() || root != null ){
            if( root != null ){
                res.add((Integer) root.val);
                stack.push(root);
                root = root.left;
            }else{
                TreeNode curr = stack.pop();
                root = curr.right;
            }
        }
        return res;
    }


    public static List<Integer> postorderTraversalIter(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( !stack.isEmpty() || root != null ){
            if( root != null ){
                res.add((Integer) root.val);
                stack.push(root);
                root = root.left;
            }else{
                TreeNode curr = stack.pop();
                root = curr.right;
            }
        }
        return res;
    }
}
