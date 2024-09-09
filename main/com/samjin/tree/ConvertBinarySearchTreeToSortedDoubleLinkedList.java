package com.samjin.tree;

public class ConvertBinarySearchTreeToSortedDoubleLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        // 中序遍历
        inOrder(root);

        // 连接头和尾，使其成为一个环
        last.right = first;
        first.left = last;

        return first;
    }

    private void inOrder(Node node) {
        if (node == null) return;

        // 遍历左子树
        inOrder(node.left);

        // 当前节点处理
        if (last != null) {
            // 连接前一个节点和当前节点
            last.right = node;
            node.left = last;
        } else {
            // 这是第一个节点
            first = node;
        }
        last = node;

        // 遍历右子树
        inOrder(node.right);
    }


}
