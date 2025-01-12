package com.samjin.tree;

import java.util.*;

public class TreeDiameter {

    public int treeDiameter(int[][] edges) {
        // Build adjacency list

        if (edges == null || edges.length == 0) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Perform first BFS/DFS to find the farthest node
        int[] firstTraversal = bfs(0, graph);
        // Perform second BFS/DFS from the farthest node to find the diameter
        int[] secondTraversal = bfs(firstTraversal[0], graph);

        return secondTraversal[1];
    }

    private int[] bfs(int startNode, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode);

        int farthestNode = startNode;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                farthestNode = node;

                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            distance++;
        }

        return new int[]{farthestNode, distance - 1};
    }
}
