package com.samjin.util;

/**
 * Created by sjjin on 5/29/17.
 */
public class TreeNode<T> {

    public TreeNode left;
    public TreeNode right;
    public T val;

    TreeNode(T val ){
        this.val = val;
    }
}
