package com.samjin.heap;

import java.util.*;

public class SlideWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length + 1 - k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++){
            if(i >= k) pq.remove(nums[i-k]);
            pq.offer(nums[i]);
            if( i+1 >= k ) res[i+1-k] = pq.peek();
        }
        return res;
    }


    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length + 1 - k];
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if(!queue.isEmpty() && queue.peekFirst() == i - k ) queue.poll();
            while(!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
            queue.offer(nums[i]);
            if(i+1>=k) res[i+1-k] = nums[queue.peek()];
        }
        return res;
    }
}
