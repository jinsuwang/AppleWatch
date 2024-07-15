package com.samjin.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        int res = 1;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            if(set.contains(num)){
                int upperNum = 0;
                int lowerNum = 0;
                set.remove(num);

                // upper elements
                while(set.contains(num + upperNum + 1)){
                    set.remove(num + upperNum + 1);
                    upperNum++;
                }

                while(set.contains(num - lowerNum - 1)){
                    set.remove(num - lowerNum - 1);
                    lowerNum++;
                }

                res = Math.max(res, 1 + lowerNum + upperNum);
            }
        }

        return res;
    }
}
