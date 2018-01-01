package com.samjin.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, curr, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int k, int[] nums) {

        res.add(new ArrayList<>(curr));

        for( int i = k; i < nums.length; i ++ ){
            // i is not the first number and it has duplicate.
            if(i > k && nums[i-1] == nums[i]) continue;
            curr.add(nums[i]);
            dfs(res, curr, i+1, nums);
            curr.remove(curr.size()-1);
        }
    }
}
