package com.samjin.hashmap;

public class ComputeEncodedProductName {

    public String computeEncodedProductName(String nameString) {
        // write your code here

        int[] charCount = new int[26]; // There are 26 letters in the English alphabet

        // Calculate the frequency of each character
        for (char c : nameString.toCharArray()) {
            charCount[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        char oddChar = 0;
        int oddCount = 0;

        // Build the first half of the palindrome and identify any odd-count character
        for (int i = 0; i < 26; i++) {
            if (charCount[i] % 2 == 1) {
                oddChar = (char) (i + 'a');
                oddCount++;
            }
            for (int j = 0; j < charCount[i] / 2; j++) {
                half.append((char) (i + 'a'));
            }
        }

        // If there's more than one character with an odd frequency, it's impossible
        // to form a palindrome. However, since the problem states that the input is
        // a symmetrical string, we assume it's always possible.
        if (oddCount > 1) {
            return ""; // This is just a safety check, though it should not be needed.
        }

        // Create the palindrome: half + (oddChar if exists) + reverse(half)
        StringBuilder result = new StringBuilder(half);
        if (oddCount == 1) {
            result.append(oddChar);
        }
        result.append(half.reverse());

        return result.toString();
    }
}
