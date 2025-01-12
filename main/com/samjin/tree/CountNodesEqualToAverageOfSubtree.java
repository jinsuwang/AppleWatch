package com.samjin.tree;

public class CountNodesEqualToAverageOfSubtree {

    int count = 0; // 全局变量记录符合条件的节点数量

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    // 后序遍历方法，返回一个数组 [子树的节点总和, 子树的节点数量]
    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // 空节点返回总和为0，节点数量为0
        }

        // 递归遍历左子树和右子树
        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        // 当前子树的总和 = 左子树总和 + 右子树总和 + 当前节点值
        int sum = left[0] + right[0] + node.val;

        // 当前子树的节点数量 = 左子树节点数 + 右子树节点数 + 1
        int numNodes = left[1] + right[1] + 1;

        // 计算平均值
        int average = sum / numNodes;

        // 判断当前节点值是否等于子树平均值
        if (node.val == average) {
            count++;
        }

        // 返回当前子树的总和和节点数量
        return new int[]{sum, numNodes};
    }
}
