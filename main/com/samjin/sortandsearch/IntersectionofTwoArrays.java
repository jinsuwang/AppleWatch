package com.samjin.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>();

        for(int i = 0; i < nums2.length; i++){
            if(i > 0 && nums2[i] == nums2[i-1]) continue;
            if(binarySearch(nums1, nums2[i])){
                tmp.add(nums2[i]);
            }
        }
        int[] res = new int[tmp.size()];
        for(int j = 0; j< tmp.size(); j++){
            res[j] = tmp.get(j);
        }
        return res;
    }

    private boolean binarySearch(int[] nums1, int val) {
        int left = 0;
        int right = nums1.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums1[mid] == val){
                return true;
            }else if( nums1[mid] < val){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
