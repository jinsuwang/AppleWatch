package com.samjin.array;

public class BulllsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretCount = new int[10]; // 0-9 digit count for secret
        int[] guessCount = new int[10];  // 0-9 digit count for guess

        // First pass to count bulls and record digit frequencies
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        // Second pass to count cows
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
