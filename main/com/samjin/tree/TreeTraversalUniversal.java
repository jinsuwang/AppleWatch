package com.samjin.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalUniversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Stack<TreeNode> st = new Stack<>();

        if (root != null) st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.peek();

            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);

                st.push(node);
                st.push(null);
            } else {
                st.pop();
                node = st.peek();
                res.add(node.val);
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);

        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                st.push(node);
                st.push(null);
                if (node.left != null) st.push(node.left);
            } else {
                st.pop();
                node = st.peek();
                st.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }
}