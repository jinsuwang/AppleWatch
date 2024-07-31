package com.samjin.array;

import java.util.Arrays;

public class HIndex {


    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;

        Arrays.sort(citations);

        int count = 1;

        for(int i = citations.length - 1; i >= 0; i--){
            if(count <= citations[i]){
                count++;
            } else {
                return count - 1;
            }
        }

        return count - 1;
    }
}
