package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Inorder traversal of both trees to get sorted lists
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);

        // Use two-pointer technique to find if there is a sum equal to target
        int i = 0, j = list2.size() - 1;

        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);

            if (sum == target) {
                return true;
            } else if (sum < target) {
                i++; // Move the first pointer to get a larger sum
            } else {
                j--; // Move the second pointer to get a smaller sum
            }
        }

        return false;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}
