package com.samjin.array;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1 ;
        int[] res = new int[nums.length];
        int index = nums.length -1 ;

        while (left <= right){
            if (Math.abs(nums[left]) < Math.abs(nums[right])){
                res[index] = nums[right] * nums[right];
                right--;
            }else{
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }
}
