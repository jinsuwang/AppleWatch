package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BSTIteratorII {

    private List<Integer> nodes; // 存储中序遍历结果
    private int index; // 当前指针位置

    // 构造函数
    public BSTIteratorII(TreeNode root) {
        nodes = new ArrayList<>();
        index = -1;
        inorderTraversal(root); // 初始化时中序遍历
    }

    // 判断是否有下一个元素
    public boolean hasNext() {
        return index + 1 < nodes.size();
    }

    // 获取下一个元素
    public int next() {
        if (hasNext()) {
            index++;
            return nodes.get(index);
        }
        throw new NoSuchElementException("No next element");
    }

    // 判断是否有前一个元素
    public boolean hasPrev() {
        return index - 1 >= 0;
    }

    // 获取前一个元素
    public int prev() {
        if (hasPrev()) {
            index--;
            return nodes.get(index);
        }
        throw new NoSuchElementException("No previous element");
    }

    // 中序遍历，将节点值存入列表
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        nodes.add(root.val);
        inorderTraversal(root.right);
    }
}
