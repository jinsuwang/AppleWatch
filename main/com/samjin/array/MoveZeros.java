package com.samjin.array;

public class MoveZeros {

    public void moveZeroes(int[] nums) {

        int nonZeroIndex = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, move it to the nonZeroIndex and increment nonZeroIndex
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // Fill the rest of the array with zeros
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
