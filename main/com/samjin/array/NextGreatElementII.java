package com.samjin.array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatElementII {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(res, -1);

        // 针对循环数组, 可以把数组遍历两边
        for (int i = 0; i < 2 * len; i++) {
            int num = nums[i % len];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }

            // 只在第一轮遍历时放入index
            if (i < len) {
                stack.push(i);
            }
        }

        return res;
    }
}
