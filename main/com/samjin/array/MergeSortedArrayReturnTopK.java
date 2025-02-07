package com.samjin.array;

import java.util.List;

public class MergeSortedArrayReturnTopK {

    public int[] merge(int[] nums1, int m, int[] nums2, int n, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, index = 0;
        while( i < m && j < n && index < k){
            if( nums1[i] < nums2[j] ){
                res[index++] = nums1[i++];
            }else{
                res[index++] = nums2[j++];
            }
        }
        while( i < m && index < k ){
            res[index++] = nums1[i++];
        }
        while( j < n && index < k ){
            res[index++] = nums2[j++];
        }
        return res;
    }
}
