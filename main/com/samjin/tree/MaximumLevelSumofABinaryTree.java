package com.samjin.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumofABinaryTree {

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE; // 最大层和
        int maxLevel = 1; // 最大层和对应的层号
        int currentLevel = 1; // 当前层号

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数量
            int levelSum = 0; // 当前层的和

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // 将子节点加入队列
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // 更新最大层和及层号
            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++; // 进入下一层
        }

        return maxLevel;
    }
}
