package com.samjin.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAnagramMappings {

    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer, Integer> bMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < B.length; i++) {
            bMap.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = bMap.get(A[i]);
        }
        return A;
    }
}
