package com.samjin.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizingBoxWeights {

    public int[] minimalHeaviestSetA(int[] arr) {
        // Step 1: Sort the array in descending order
        Arrays.sort(arr);

        int totalSum = 0;
        for (int weight : arr) {
            totalSum += weight;
        }

        List<Integer> subsetA = new ArrayList<>();
        int sumA = 0;
        int sumB = totalSum;

        // Step 2: Select elements for subset A from the end (largest elements)
        for (int i = arr.length - 1; i >= 0; i--) {
            sumA += arr[i];
            sumB -= arr[i];
            subsetA.add(arr[i]);

            if (sumA > sumB) {
                break;
            }
        }

        // Step 3: Sort subset A in ascending order
        subsetA.sort(Integer::compareTo);

        // Convert the list to an array
        int[] result = new int[subsetA.size()];
        for (int i = 0; i < subsetA.size(); i++) {
            result[i] = subsetA.get(i);
        }

        return result;
    }
}
