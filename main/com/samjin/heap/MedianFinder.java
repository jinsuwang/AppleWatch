package com.samjin.heap;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() == minHeap.size() + 2){
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() == maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
    }


    public double findMedian() {
        if (maxHeap.size() != minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek() ) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}