package com.samjin.array;

public class MergeSortedArray {


//    int[] num1 = new int[]{4,5,6,-1,-1,-1};
//    int[] num2 = new int[]{1,2,3};

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0){
            if(nums1[m-1] >= nums2[n-1]){
                nums1[m+n-1] = nums1[m-1]; m--;
            }else{
                nums1[m+n-1] = nums2[n-1]; n--;
            }
        }
        while(n > 0){
            nums1[n-1] = nums2[n-1];
            n--;
        }
    }
}
