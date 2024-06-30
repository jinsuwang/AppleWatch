package com.samjin.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjjin on 8/21/17.
 */


//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//你可以按任意顺序返回答案。
public class TwoSum {

    public int[] getTwoSum(int[] nums, int target ){
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret;

        for( int i = 0; i < nums.length; i++ ){
            int curr = nums[i];
            if (map.get(target - curr) != null ){
                return new int[]{map.get(target - curr), i};
            }else{
                map.put(curr, i);
            }
        }
        return null;
    }
}


//        Map<Integer, Integer> map = new HashMap<>();
//        int[] ret;
//        for( int i = 0; i < nums.length; i++ ){
//            int currVal = nums[i];
//            if( map.get(target - currVal) != null ){
//                return new int[]{map.get(target - currVal), i};
//            }else{
//                map.put(currVal, i);
//            }
//        }
//        // not matched
//        return null;