package com.samjin.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                // If the value at this index is already negative, it means this number has been seen before
                result.add(index + 1);
            } else {
                // Mark the value at this index as seen by making it negative
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}
