package com.samjin.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];

        for(int i = k - 1; i>=0; i--){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
