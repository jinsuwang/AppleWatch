package com.samjin.amazon;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayGeneratorService {

    public static int[] generateLargestSequence(int[] arr, String state, int m) {
        int n = arr.length;
        StringBuilder stateBuilder = new StringBuilder(state);
        List<Integer> S = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int maxVal = -1;
            int maxIndex = -1;

            // Find the largest available element
            for (int j = 0; j < n; j++) {
                if (stateBuilder.charAt(j) == '1' && arr[j] > maxVal) {
                    maxVal = arr[j];
                    maxIndex = j;
                }
            }

            // Append the largest available element to S
            S.add(maxVal);

            // Update the state
            for (int j = 1; j < n; j++) {
                if (stateBuilder.charAt(j) == '0' && stateBuilder.charAt(j - 1) == '1') {
                    stateBuilder.setCharAt(j, '1');
                }
            }
        }

        // Convert the list to an array for the final result
        int[] result = S.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}
