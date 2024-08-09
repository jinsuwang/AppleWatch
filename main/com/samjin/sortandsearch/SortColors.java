package com.samjin.sortandsearch;

public class SortColors {

    public void sortColors(int[] nums) {

        int point0 = 0;
        int point2 = nums.length - 1;
        int i = 0;

        while(i <= point2){
            if(nums[i] == 0){
                swap(nums, point0, i);
                i++;
                point0++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, point2, i);
                point2--;
            }
        }
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}