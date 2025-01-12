package com.samjin.tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // 构建树的邻接表
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // 调用 DFS 计算最小时间
        return dfs(0, -1, tree, hasApple);
    }

    private int dfs(int node, int parent, List<List<Integer>> tree, List<Boolean> hasApple) {
        int time = 0;

        // 遍历当前节点的所有子节点
        for (int child : tree.get(node)) {
            if (child != parent) {  // 避免回溯到父节点
                int childTime = dfs(child, node, tree, hasApple);
                if (childTime > 0 || hasApple.get(child)) {
                    time += childTime + 2; // 加上子节点往返的时间
                }
            }
        }

        return time;
    }
}
