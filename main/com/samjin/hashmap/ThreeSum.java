package com.samjin.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return ret;

        Arrays.sort(nums);

        // int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] input = new int[]{-4,-1,-1, 0, 1, 2};

        for( int i = 0; i < nums.length - 2; i++){
            if( i > 0 && nums[i]==nums[i-1]) continue;
            int start = i+1;
            int end = nums.length - 1;
            while( start < end  ){
                int sum = nums[start] + nums[i] + nums[end];
                if( sum == 0 ) {
                    List<Integer> candidate = Arrays.asList(nums[start], nums[i], nums[end]);
                    ret.add( candidate ); start++; end--;
                    while(start < end && nums[start] == nums[start-1]) start++;
                    while(start < end && nums[end] == nums[end+1]) end--;
                }
                else if( sum > 0 ) end--;
                else start++;
            }
        }
        return ret;
    }
}
