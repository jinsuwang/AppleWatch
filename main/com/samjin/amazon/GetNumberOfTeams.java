package com.samjin.amazon;

import java.util.Arrays;

public class GetNumberOfTeams {


    public long getNumTeams(int[] skill, int min_skill, int max_skill) {
        // write your code here

        Arrays.sort(skill);  // Sort the array to use two-pointer approach
        int n = skill.length;
        long count = 0;

        // Two-pointer approach
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;

            // Find the smallest j such that skill[i] + skill[j] >= min_skill
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (skill[i] + skill[mid] >= min_skill) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int lowerBound = left;

            // Reset the left and right pointers
            left = i + 1;
            right = n - 1;

            // Find the largest j such that skill[i] + skill[j] <= max_skill
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (skill[i] + skill[mid] <= max_skill) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int upperBound = right;

            if (lowerBound <= upperBound) {
                count += (upperBound - lowerBound + 1);
            }
        }

        return count;
    }
}
