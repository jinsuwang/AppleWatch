package com.samjin.array;

import java.util.HashMap;

public class DegreeOfAnArray {

    class Node {
        int count;
        int start;

        Node(int count, int start) {
            this.count = count;
            this.start = start;
        }
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Node> map = new HashMap<>();

        int res = 0;
        int degree = 0;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(!map.containsKey(num)) {
                map.put(num, new Node(1, i));
            } else {
                Node node = map.get(num);
                node.count++;
                map.put(num, node);
            }

            Node node = map.get(num);
            if(node.count > degree) {
                degree = node.count;
                res = i - node.start + 1;
            } else if (node.count == degree) {
                res = Math.min(res, i - node.start + 1);
            }
        }

        return res;
    }
}
