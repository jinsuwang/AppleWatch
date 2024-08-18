package com.samjin.hashmap;

import java.util.*;

public class MinimumNumberOfKeypresses {
    public int minimumKeypresses(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // List to store the frequencies, sorted in descending order
        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        frequencies.sort(Collections.reverseOrder());

        int totalKeypresses = 0;
        int keyPressPosition = 1;

        // Assign characters to key positions based on frequency
        for (int i = 0; i < frequencies.size(); i++) {
            int freq = frequencies.get(i);
            int keyPressesRequired = (i / 9) + 1; // 1st 9 keys require 1 press, next 9 require 2, etc.
            totalKeypresses += freq * keyPressesRequired;
        }

        return totalKeypresses;

    }
}
