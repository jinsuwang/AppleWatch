package com.samjin.array;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        res[0] = 1;
        int p = 1;
        for(int i = 1; i < nums.length; i++){
            p = p * nums[i-1];
            res[i] = p;
        }

        p = 1;
        for(int i = nums.length - 2; i >= 0; i --){
            p = p * nums[i+1];
            res[i] *= p;
        }

        return res;
    }
}
