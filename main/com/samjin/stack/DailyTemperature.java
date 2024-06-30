package com.samjin.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {

        int lens = temperatures.length;
        int[] res = new int[lens];

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for(int i = 0; i < lens; i++){
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;

    }
}
