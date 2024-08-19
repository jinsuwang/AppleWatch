package com.samjin.greedy;

import java.util.Arrays;

public class BagofToken {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);  // Step 1: Sort the tokens array
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) {
                // Step 2a: Gain score by flipping the token at the left
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                // Step 2b: Gain power by sacrificing score
                power += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }

        return maxScore;
    }

}
