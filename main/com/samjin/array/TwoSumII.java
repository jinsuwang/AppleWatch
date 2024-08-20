package com.samjin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum < target) left++;
            else if(sum > target) right--;
            else {
                return new int[]{left+1, right+1};
            }
        }
        return null;
    }

    public static List<List<Integer>>  twoSumDuplicate(int[] numbers, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;

        while(left < right){

            int curr = numbers[left] + numbers[right];
            if ( curr == target){
                res.add(Arrays.asList(numbers[left], numbers[right]));
                while(left < right && numbers[left] == numbers[left+1]){
                    left++;
                    res.add(Arrays.asList(numbers[left], numbers[right]));
                }

                while( right > left && numbers[right] == numbers[right-1]){
                    right--;
                    res.add(Arrays.asList(numbers[left], numbers[right]));
                }
                left++;
                right--;
            }else if (curr < 0){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = twoSumDuplicate(new int[]{1,1,3,4}, 4);

        for(List<Integer> e: res){
            System.out.println(e);
        }
    }
}
