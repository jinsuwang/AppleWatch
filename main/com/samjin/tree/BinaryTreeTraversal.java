package com.samjin.tree;

import com.samjin.linkedlist.ListNode;

import java.util.*;

public class BinaryTreeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversalHelper(res, root);
        return res;
    }

    private void preorderTraversalHelper(List<Integer> res, TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        preorderTraversalHelper(res, node.left);
        preorderTraversalHelper(res, node.right);
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while( !stack.isEmpty() ){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null ){
                stack.push(node.right);
            }
            if (node.left != null ){
                stack.push(node.left);
            }
        }

        return res;
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while( curr != null &&  !stack.isEmpty() ){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }


    public List<Integer> postorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while( !stack.isEmpty() ){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }

        Collections.reverse(res);
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while(len > 0){
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);

                if(tmpNode.left != null) queue.offer(tmpNode.left);
                if(tmpNode.right != null) queue.offer(tmpNode.right);
                len--;
            }

            res.add(itemList);
        }

        return res;
    }


    int min = 0;
    int max = 0;

    private void helper(TreeNode root, int index){
        if(root == null) return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        helper(root.left, index -1);
        helper(root.right, index +1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<>();
        if (root == null) return res;
        helper(root, 0);

        for(int i = min; i <= max; i++){
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();

        queue.offer(root);
        index.offer(-min);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int currIndex = index.poll();

            res.get(currIndex).add(curr.val);

            if (curr.left != null) {
                queue.offer(curr.left);
                index.offer(currIndex - 1);
            }


            if (curr.right != null) {
                queue.offer(curr.right);
                index.offer(currIndex + 1);
            }
        }

        return res;

    }



    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        helper2(root, 0);

        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();

        queue.offer(root);
        index.offer(-min);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int currIndex = index.poll();
                if (!map.containsKey(currIndex)) {
                    map.put(currIndex, new ArrayList<>());
                }
                map.get(currIndex).add(curr.val);

                // res.get(currIndex).add(curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                    index.offer(currIndex - 1);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                    index.offer(currIndex + 1);
                }
            }

            for (Integer currIndex : map.keySet()) {
                List<Integer> list = map.get(currIndex);
                Collections.sort(list);
                res.get(currIndex).addAll(list);
            }
        }

        return res;
    }

    // 找到树的最左边和最右边
    private void helper2(TreeNode root, int index) {
        if (root == null)
            return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        helper2(root.left, index - 1);
        helper2(root.right, index + 1);
    }


    public List<List<Integer>> verticalOrderDFS(TreeNode root) {
        // Map to store the nodes' values in each column
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        // Variable to store the range of the column index
        int[] minMax = new int[2]; // minMax[0] = min column index, minMax[1] = max column index

        // Perform DFS traversal
        dfs(root, 0, 0, columnTable, minMax);

        List<List<Integer>> result = new ArrayList<>();

        // Process each column in increasing order
        for (int col = minMax[0]; col <= minMax[1]; col++) {
            result.add(columnTable.get(col));
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, Map<Integer, List<Integer>> columnTable, int[] minMax) {
        if (node == null) return;

        // Update the range of column index
        minMax[0] = Math.min(minMax[0], col);
        minMax[1] = Math.max(minMax[1], col);

        // Add the node's value to the corresponding column
        columnTable.putIfAbsent(col, new ArrayList<>());
        columnTable.get(col).add(node.val);

        // Traverse the left and right children
        dfs(node.left, row + 1, col - 1, columnTable, minMax);
        dfs(node.right, row + 1, col + 1, columnTable, minMax);
    }

}