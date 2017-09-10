package com.samjin.hapmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjjin on 8/21/17.
 */
public class TwoSum {

    public int[] getTwoSum(int[] nums, int target ){

        Map<Integer, Integer> map = new HashMap<>();
        int[] ret;
        for( int i = 0; i < nums.length; i++ ){
            int currVal = nums[i];
            if( map.get(target - currVal) != null ){
                return new int[]{map.get(target - currVal), i};
            }else{
                map.put(currVal, i);
            }
        }
        // not matched
        return null;
    }
}
