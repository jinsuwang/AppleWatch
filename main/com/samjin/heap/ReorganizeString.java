package com.samjin.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String s) {
        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max heap (priority queue) to store characters by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            // Take out the two most frequent characters
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            // Append them to the result
            result.append(first);
            result.append(second);

            // Decrease the frequency and add them back if they still have remaining occurrences
            frequencyMap.put(first, frequencyMap.get(first) - 1);
            frequencyMap.put(second, frequencyMap.get(second) - 1);

            if (frequencyMap.get(first) > 0) {
                maxHeap.offer(first);
            }
            if (frequencyMap.get(second) > 0) {
                maxHeap.offer(second);
            }
        }

        // If there is one character left, check if it can be placed
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (frequencyMap.get(last) > 1) {
                return ""; // Not possible to reorganize
            }
            result.append(last);
        }

        return result.toString();
    }
}
