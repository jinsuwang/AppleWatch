package com.samjin.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {

    public static class Pair<T>{

        T t;
        T c;
        public Pair(T t, T c){
            this.t = t;
            this.c = c;
        }

        public T getKey(){
            return t;
        }

        public T getValue(){
            return c;
        }
    }

    Deque<Pair<Integer>> deque;
    int total;
    public HitCounter() {
        deque = new LinkedList<>();
        total = 0;
    }

    public void hit(int timestamp) {
        if(deque.isEmpty()) {
            deque.add(new Pair<Integer>(timestamp, 1));
        } else {
            if(deque.getLast().getKey() == timestamp) {
                int count = deque.getLast().getValue();
                deque.removeLast();
                deque.add(new Pair<Integer>(timestamp, count + 1));
            } else {
                deque.add(new Pair<Integer>(timestamp, 1));
            }
        }

        total++;
    }

    public int getHits(int timestamp) {
        while(!deque.isEmpty() && deque.getFirst().getKey() + 300 <= timestamp) {
            int count = deque.getFirst().getValue();
            deque.removeFirst();
            total -= count;
        }

        return total;
    }
}
