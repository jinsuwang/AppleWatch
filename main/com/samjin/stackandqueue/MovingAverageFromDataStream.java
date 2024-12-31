package com.samjin.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {

    Deque<Integer> queue = new LinkedList<Integer>();
    int size;
    double sum;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        sum = 0;
    }

    public double next(int val) {

        if (queue.size() >= this.size){
            int remove = queue.removeFirst();
            queue.addLast(val);
            sum -= remove;
            sum += val;
        }else{
            queue.addLast(val);
            sum += val;
        }
        return sum / queue.size();
    }
}
