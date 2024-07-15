package com.samjin.backtracking;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }

        if(i == -1){
            Arrays.sort(nums);
            return;
        }

        int j  = nums.length - 1;
        while(j >= 0 && nums[j] <= nums[i]){
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i){
        int left = i;
        int right = nums.length - 1;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
