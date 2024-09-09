package com.samjin.string;

public class MaximumSwap {

    public int maximumSwap(int num) {
        // Convert the number to a char array representing each digit
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        // Create an array to store the index of the maximum digit seen from the right
        int[] maxIdxRight = new int[n];
        maxIdxRight[n - 1] = n - 1;

        // Fill the maxIdxRight array by comparing digits from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[maxIdxRight[i + 1]]) {
                maxIdxRight[i] = i;
            } else {
                maxIdxRight[i] = maxIdxRight[i + 1];
            }
        }

        // Traverse the digits to find the first place to swap
        for (int i = 0; i < n; i++) {
            // If there's a larger digit on the right, swap
            if (digits[i] != digits[maxIdxRight[i]]) {
                // Swap digits[i] and digits[maxIdxRight[i]]
                char temp = digits[i];
                digits[i] = digits[maxIdxRight[i]];
                digits[maxIdxRight[i]] = temp;

                // Return the new number as an integer
                return Integer.parseInt(new String(digits));
            }
        }

        // If no swap was done, return the original number
        return num;
    }
}
