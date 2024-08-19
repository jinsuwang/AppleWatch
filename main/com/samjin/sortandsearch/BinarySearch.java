package com.samjin.sortandsearch;

public class BinarySearch {


    // 左闭右闭
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (nums[mid] == target) return mid;
            if (target < nums[mid]){
                right = mid - 1;
            }
            if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }
    // 左闭右开
    public static int search2 (int[] nums, int target){
        if (target < nums[0] || target > nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right){

            int mid = left + (right - left) / 2;
            System.out.println(mid);

            if (nums[mid] == target) return mid;

            else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    // 左右逼近
    public static int search3(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid;
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
    public static void main(String[] args) {
        int[] test = new int[]{5};
        System.out.println(search2(test, 5));
    }
}






















