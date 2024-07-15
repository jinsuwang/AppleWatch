package com.samjin.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int sum=0,result=0;
        Map<Integer,Integer> preSum=new HashMap<>();

        preSum.put(0,1);
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            if(preSum.containsKey(sum-k)){
                result+=preSum.get(sum-k);
            }
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return result;
    }

    public int subarraySum2(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, right = 0, sum = 0, count = 0;
        int n = nums.length;

        while (right < n) {
            sum += nums[right];
            if (sum == k){
                count++;
                sum -= nums[left++];
            }
            right++;
        }

        return count;
    }
}
