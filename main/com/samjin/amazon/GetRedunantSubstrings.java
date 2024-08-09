package com.samjin.amazon;

import java.util.HashMap;
import java.util.Map;

public class GetRedunantSubstrings {

    public int getRedundantSubstrings(String word, int a, int b) {
        // write your code here

        int n = word.length();
        int redundantCount = 0;

        // HashMap to store frequency of (a * V - b * C) differences
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);  // Start with 0 difference

        int vowelCount = 0, consonantCount = 0;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (isVowel(ch)) {
                vowelCount++;
            } else {
                consonantCount++;
            }

            // Calculate the current difference
            int currentDifference = a * vowelCount - b * consonantCount;

            // If this difference has been seen before, it means there are substrings that satisfy the condition
            redundantCount += frequencyMap.getOrDefault(currentDifference, 0);

            // Update the map with the current difference
            frequencyMap.put(currentDifference, frequencyMap.getOrDefault(currentDifference, 0) + 1);
        }

        return redundantCount;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

}
