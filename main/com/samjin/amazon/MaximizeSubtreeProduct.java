package com.samjin.amazon;

import java.util.ArrayList;
import java.util.List;

public class MaximizeSubtreeProduct {

    private static List<List<Integer>> tree;
    private static int[] subtreeSize;
    private static int totalNodes;

    public static int maxProduct(int n, int[][] edges) {
        totalNodes = n;
        tree = new ArrayList<>();
        subtreeSize = new int[n + 1]; // Size array, 1-based index

        // Initialize tree as an adjacency list
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // Populate the tree
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // Compute subtree sizes via DFS
        dfs(1, -1); // Start DFS from node 1 (or any arbitrary root)

        // Now calculate the maximum product
        long maxProduct = 0;

        for (int i = 2; i <= n; i++) { // Start from node 2 to n
            // The size of one subtree is subtreeSize[i]
            // The size of the other subtree is totalNodes - subtreeSize[i]
            long product = (long) subtreeSize[i] * (totalNodes - subtreeSize[i]);
            maxProduct = Math.max(maxProduct, product);
        }

        return (int) maxProduct;
    }

    private static void dfs(int node, int parent) {
        subtreeSize[node] = 1; // Start with the node itself

        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) { // Avoid going back to the parent
                dfs(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
            }
        }
    }
}
