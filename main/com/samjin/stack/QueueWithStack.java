package com.samjin.stack;

import java.util.Queue;
import java.util.Stack;

public class QueueWithStack {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public QueueWithStack(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x){
        stackIn.push(x);
    }

    public int pop(){
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek(){
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dumpStackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.empty()){
            stackOut.push(stackIn.pop());
        }
    }
}
