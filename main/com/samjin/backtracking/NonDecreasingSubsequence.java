package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubsequence {

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        dfs(res, curr, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int k, int[] nums) {

        if (curr.size()>= 2){
            res.add(new ArrayList<>(curr));
        }

        for( int i = k; i < nums.length; i ++ ){
            // i is not the first number and it has duplicate.
            if(curr.size() == 0 || (i > k && nums[i] == nums[i-1])){
                curr.add(nums[i]);
                dfs(res, curr, i+1, nums);
                curr.remove(curr.size()-1);
            };
        }
    }
}
