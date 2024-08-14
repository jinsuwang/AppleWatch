package com.samjin.tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfaBinarySearchTree {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return root;

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q); // l1
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q); // l1 => p
        }else{
            return root;
        }

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }




    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };


    class Solution {
        public Node lowestCommonAncestor3(Node p, Node q) {
            Set<Node> ancestors = new HashSet<>();

            // 遍历 p 的祖先节点并将它们加入到 HashSet 中
            while (p != null) {
                ancestors.add(p);
                p = p.parent;
            }

            // 遍历 q 的祖先节点，如果某个节点已经在 HashSet 中，说明它是 LCA
            while (q != null) {
                if (ancestors.contains(q)) {
                    return q;
                }
                q = q.parent;
            }

            return null; // 如果没有找到 LCA，返回 null
        }

    }
}
