package com.samjin.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    class DataNode{

        TreeNode node;
        int index;
        public DataNode(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {


        int res = 0;
        Queue<DataNode> queue = new LinkedList<>();
        queue.add(new DataNode(root, 0));


        while(!queue.isEmpty()){
            int size = queue.size();

            int headIndex = 0;
            int tailIndex = 0;

            for(int i = 0; i < size; i++){

                DataNode node = queue.poll();
                if (i == 0){
                    headIndex = node.index;
                }

                tailIndex = node.index;

                if (node.node.left != null){
                    queue.offer(new DataNode(node.node.left, 2 * node.index ));
                }
                if (node.node.right != null){
                    queue.offer(new DataNode(node.node.right, 2 * node.index + 1 ));
                }
            }

            res = Math.max(res, tailIndex - headIndex + 1);
        }

        return res;
    }
}
