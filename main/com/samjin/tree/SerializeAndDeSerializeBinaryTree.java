package com.samjin.tree;

import com.samjin.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sjjin on 6/1/17.
 */
public class SerializeAndDeSerializeBinaryTree {

    /**
     * Serialize a tree to a string
     * @return String representation of tree
     */
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        while( !stack.isEmpty() || root != null ){
            if( root != null ){
                sb.append(root.val);
                stack.add(root);
                root = root.left;
            }else{
                sb.append("#");
                TreeNode curr = stack.pop();
                root = curr.right;
            }
        }
        return sb.toString();
    }


    public String serializeRecur(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString( root, sb );
        return sb.toString();
    }


    /*  pre-order traversal.
     */
    private static void buildString(TreeNode node, StringBuilder sb) {
        if( node == null ){
            sb.append("#");
            return;
        }else {
            sb.append(node.val);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    /**
     * convert a inorder traversal string version of a tree to a binary tree.
     * @return the root of tree
     */
    public TreeNode deserialzie(String str){

        if(str == null || str.isEmpty() ) return null;

        // convert String to queue for futhur usage.
        Queue<String> queue = new LinkedList<String>();
        for(Character c : str.toCharArray()){
            queue.add(c.toString());
        }


        return null;
    }

}
