package com.samjin.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetCPUOperation {

    public static int[] getOperations(int[] resource) {
        int n = resource.length;
        List<Integer> operations = new ArrayList<>();

        // Copy and sort the array to know the correct order
        int[] sortedResource = resource.clone();
        Arrays.sort(sortedResource);

        // Use a pointer to track progress on the sorted array
        int pointer = 0;

        while (pointer < n) {
            int minVal = sortedResource[pointer];

            // Find the position of minVal in the original resource array
            int pos = -1;
            for (int i = pointer; i < n; i++) {
                if (resource[i] == minVal) {
                    pos = i;
                    break;
                }
            }

            if (pos != pointer) {
                // Record the operation (value of x)
                operations.add(resource[pos]);

                // Partition the resource array
                List<Integer> leftPart = new ArrayList<>();
                List<Integer> rightPart = new ArrayList<>();

                for (int i = pointer; i < n; i++) {
                    if (resource[i] < resource[pos]) {
                        leftPart.add(resource[i]);
                    } else {
                        rightPart.add(resource[i]);
                    }
                }

                // Merge the left and right parts
                int idx = pointer;
                for (int val : leftPart) {
                    resource[idx++] = val;
                }
                for (int val : rightPart) {
                    resource[idx++] = val;
                }
            }

            pointer++;
        }

        if (operations.isEmpty()) {
            return new int[]{-1};
        }

        // Convert the list to an array
        int[] result = new int[operations.size()];
        for (int i = 0; i < operations.size(); i++) {
            result[i] = operations.get(i);
        }

        return result;
    }

}
