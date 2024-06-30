package com.samjin.array;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];
        int i = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
//            System.out.println("left is " + left + ". right is " + right + " i is " + i) ;

            if (nums[left] * nums[left] <= nums[right] * nums[right]){
                res[i--] = nums[right] * nums[right];
                right--;
            }else{
                res[i--] = nums[left] * nums[left];
                left++;
            }
        }

        return res;
    }
}
