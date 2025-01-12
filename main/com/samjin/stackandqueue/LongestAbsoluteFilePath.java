package com.samjin.stackandqueue;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();

        int max = 0;
        int currLen = 0;
        for(String line : input.split("\n")) {
            String[] paths = line.split("\t");

            while(stack.size() >= paths.length) {
                currLen -= stack.pop().length();
            }

            String path = paths[paths.length - 1];
            stack.push(path + "/");
            currLen += path.length() + 1;

            if(path.indexOf(".") != -1) {
                max = Math.max(max, currLen - 1);
            }
        }

        return max;
    }
}
