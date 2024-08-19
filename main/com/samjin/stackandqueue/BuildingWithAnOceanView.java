package com.samjin.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildingWithAnOceanView {

    public int[] findBuildings(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        for(int i = heights.length - 1; i >= 0; i--){
            int height = heights[i];
            if (i == heights.length - 1){
                res.add(i);
                stack.push(height);
            }else{
                if(height < stack.peek()) continue;

                while(!stack.isEmpty() && height > stack.peek()){
                    stack.pop();
                }

                stack.push(height);
                if(stack.size() == 1) res.add(i);
            }
        }
        int[] r = new int[res.size()];

        for(int i = 0; i < res.size(); i++){
            r[res.size() - i - 1] = res.get(i);
        }

        return r;
    }
}
