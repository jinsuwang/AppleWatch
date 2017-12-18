package com.samjin.sortandsearch;

public class KthLargestElement {

    // Quick select
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, 0, nums.length - 1, k);
    }

    private int findKthLargestHelper(int[] nums, int start, int end, int k) {

        int left = start, right = end;

        int pivot = nums[ start + ( end - start )/2 ];

        while(left <= right){
            while(left <= right && nums[left] < pivot ) left++;
            while(left <= right && nums[right] > pivot ) right--;

            if(left <= right ){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;

                left++; right--;
            }
        }

        if(start + k - 1 <= right ) return findKthLargestHelper( nums, start, right, k );
        if(start + k - 1 >= left) return findKthLargestHelper(nums, left, end, k - ( left - start) );

        return nums[right + 1];
    }
}
