package com.samjin.sortandsearch;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid+1]) {
                end = mid;
            }else{
                start = mid;
            }
        }

        return nums[start] > nums[end] ? start : end;

    }
}
