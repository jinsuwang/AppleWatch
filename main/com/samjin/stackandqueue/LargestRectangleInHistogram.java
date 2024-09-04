package com.samjin.stackandqueue;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){
            int currHeight = i == heights.length ? 0 : heights[i];

            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                int tempHeight = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = tempHeight * (i - start - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
