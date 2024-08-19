package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 0, 1);
        return res;
    }

    private void dfs(int target, int k, int sum, int startIndex ) {
        if (sum > target) return;

        if (path.size() > k ) return;

        if (path.size() == k){
            if (sum == target) res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++){
            path.add(i);
            dfs(target, k, sum + i, i+1);
            path.removeLast();
        }
    }
}
