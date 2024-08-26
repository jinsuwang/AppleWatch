package com.samjin.sortandsearch;

import java.util.*;

public class SortFreatureByPopularity {

    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        // Initialize the frequency map and index map
        for (int i = 0; i < features.length; i++) {
            frequencyMap.put(features[i], 0);
            indexMap.put(features[i], i);
        }

        // Count the frequency of each feature in the responses
        for (String response : responses) {
            Set<String> seen = new HashSet<>();
            String[] words = response.split(" ");
            for (String word : words) {
                if (frequencyMap.containsKey(word) && !seen.contains(word)) {
                    frequencyMap.put(word, frequencyMap.get(word) + 1);
                    seen.add(word);
                }
            }
        }

        // Sort the features based on frequency, and if equal, based on their original order
        Arrays.sort(features, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return freqB - freqA; // Higher frequency comes first
            }
            return indexMap.get(a) - indexMap.get(b); // Preserve original order
        });

        return features;
        }
}
