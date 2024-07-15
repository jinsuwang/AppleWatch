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


    Node head = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;

        helper(root);

        head.right.left = prev;
        prev.right = head.right;

        return head.right;

    }

    private void helper(Node root) {
        if (root == null) return;

        helper(root.left);

        if (head == null){
            head = new Node();
            head.right = root;
        }else{
            prev.right = root;
            root.left = prev;
        }

        prev = root;
    }


}
