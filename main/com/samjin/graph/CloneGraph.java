package com.samjin.graph;

import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 创建新的节点（克隆当前节点），但暂时不克隆它的邻居
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 将当前节点和克隆的节点存入哈希表
        visited.put(node, cloneNode);

        // 初始化队列，进行BFS遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for(Node neighbor: current.neighbors){

                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
