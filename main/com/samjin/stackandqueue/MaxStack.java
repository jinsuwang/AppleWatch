package com.samjin.stackandqueue;

import java.util.Stack;

    class MaxStack {

        private Stack<Integer> stack;
        private Stack<Integer> maxStack;

        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            int max = Integer.MIN_VALUE;
            if (!maxStack.isEmpty()) {
                max = maxStack.peek();
            }

            if (max > x) {
                maxStack.push(max);
            } else {
                maxStack.push(x);
            }
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> buffer = new Stack<>();
            while (top() != max) {
                buffer.push(pop());
            }
            // Pop the max element from both stacks
            pop();
            while (!buffer.isEmpty()) {
                push(buffer.pop());
            }
            return max;
        }

}
