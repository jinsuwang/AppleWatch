package com.samjin.stack;

import java.util.Stack;

class CustomStack {


    private Stack<Integer> customStack;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.customStack = new Stack<>();
    }

    public void push(int x) {
        if (customStack.size() < maxSize) {
            customStack.push(x);
        }
    }

    public int pop() {
        if (customStack.isEmpty()) {
            return -1;
        } else {
            return customStack.pop();
        }
    }

    public void increment(int k, int val) {
        int size = Math.min(k, customStack.size());
        for (int i = 0; i < size; i++) {
            customStack.set(i, customStack.get(i) + val);
        }
    }
}
