package com.samjin.sortandsearch;

public class KthMissingPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {

        int left = 0, right = arr.length;

        // 使用二分查找定位
        while (left < right) {
            int mid = left + (right - left) / 2;

            // 计算 mid 前缺失的数字数量
            if (arr[mid] - (mid + 1) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        // left 是找到的索引位置，结果是 k 个缺失的数字应在此位置
        return left + k;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,7,11};
        System.out.println(findKthPositive(arr, 5));
    }
}
