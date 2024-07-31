package com.samjin.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by sjjin on 12/14/17.
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(nums).forEach(pq::offer);

        while (!pq.isEmpty() && k > 1 ){
            pq.poll();
            k--;
        }

        return pq.peek();
    }
}