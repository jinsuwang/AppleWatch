package com.samjin.array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;

        for(int num : nums){
            if(count == 0){
                res = num;
            }

            if(num != res){
                count--;
            } else {
                count++;
            }
        }

        return res;
    }

}
