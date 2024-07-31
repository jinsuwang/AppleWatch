package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        dfs(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> path, int[] candidates, int target, int sum, int idx) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(res, path, candidates, target, sum + candidates[i], i+1);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}
