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
        System.out.println("Adding " + path.toString() + " to result.");
        res.add(new ArrayList<>(path));

        for(int k = i; k < nums.length; k++ ){
            path.add(nums[k]);
            dfs(nums, k+1, path, res);
            System.out.println("Removing...");
            path.remove(path.size() - 1);
        }
    }
}
