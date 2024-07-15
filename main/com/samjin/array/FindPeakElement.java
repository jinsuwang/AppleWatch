package com.samjin.array;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1]){
                end = mid;
            } else {
                start = mid;
            }
        }

        // 最后start和end一定在相邻的位置
        if(nums[start] > nums[end]){
            return start;
        } else {
            return end;
        }
    }
}
