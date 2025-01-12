package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsetsDfs(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for(int k = i; k < nums.length; k++ ){
            path.add(nums[k]);
            dfs(nums, k+1, path, res);
            path.remove(path.size() - 1);
        }
    }
}


List<List<Integer>> res = new ArrayList<>();
List<Integer> path = new ArrayList<>();

public List<List<Integer>> subsets(int[] nums) {
    backtrace(nums, 0);
    return res;
}

private void backtrace(int[] nums, int start){
    res.add(new ArrayList<>(path));
    for(int i = start; i < nums.length; i++){
        path.add(nums[start]);
        backtrace(nums, start+1);
        path.removeLast();
    }
}