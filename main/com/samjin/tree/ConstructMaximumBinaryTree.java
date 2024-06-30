package com.samjin.tree;

import com.sun.source.tree.Tree;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
         return constructMaximumBinaryTreeHelpper(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTreeHelpper(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) return null;
        if (rightIndex - leftIndex == 1) return new TreeNode(nums[leftIndex]);

        int maxIndex = leftIndex;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal){
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);

        root.left = constructMaximumBinaryTreeHelpper(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTreeHelpper(nums, maxIndex+1, rightIndex);

        return root;
    }
}
