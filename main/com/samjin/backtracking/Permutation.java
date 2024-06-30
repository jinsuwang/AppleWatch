package com.samjin.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjjin on 4/8/18.
 */
public class Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(res, curr, nums, used);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] used) {
        if(curr.size() == nums.length){
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i = 0; i < used.length; i++){
            if(i > 0 && !used[i-1] && nums[i] == nums[i-1]) continue;
            if(!used[i]){
                used[i] = true;
                curr.add(nums[i]);
                dfs(res, curr, nums, used);
                curr.remove(curr.size()-1);
                used[i] = false;
            }
        }
    }
}
