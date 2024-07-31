package com.samjin.linkedlist;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {

    class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode() {}

        public TreeLinkNode(int _val) {
            val = _val;
        }

        public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> level = new LinkedList<>();
        level.add(root);
        connect(level);
    }

    private void connect(LinkedList<TreeLinkNode> level) {
        LinkedList<TreeLinkNode> newLevel = new LinkedList<>();
        if (level.isEmpty()) return;
        while (!level.isEmpty()) {
            TreeLinkNode n = level.remove();
            if (n == null) return;
            n.next = level.peek();
            if (n.left != null) newLevel.add(n.left);
            if (n.right != null) newLevel.add(n.right);
        }

        connect(newLevel);
    }

}
