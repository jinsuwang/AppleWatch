package com.samjin.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length < 4) return res;

        Arrays.sort(nums);

        for( int i = 0; i < nums.length - 3; i++){
            int curr = nums[i];
            int newTarget = target - curr;
            List<ArrayList<Integer>> threeSumResult = ThreeSum(newTarget, nums, i+1);
            for(List<Integer> e : threeSumResult){
                e.add(0, curr);
            }
            res.addAll(threeSumResult);
        }
        return res;
    }

    private List<ArrayList<Integer>> ThreeSum(int newTarget, int[] nums, int start) {
        List<ArrayList<Integer>> ret = new ArrayList<>();

        for(int i = start; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == newTarget){
                    List<Integer> candidate = Arrays.asList(nums[left], nums[i], nums[right]);
                    ret.add( new ArrayList<>(candidate) ); left++; right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
                else if( sum > 0 ) right--;
                else left++;
            }
        }
        return ret;
    }

}
