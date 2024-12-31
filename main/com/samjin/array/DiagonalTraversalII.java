package com.samjin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversalII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        int maxKey = 0; // 用来记录最大的对角线索引 i + j

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j; // 对角线编号

                // 如果这个对角线还没有被记录，先初始化
                diagonalMap.putIfAbsent(key, new ArrayList<>());

                // 把元素加入该对角线
                diagonalMap.get(key).add(nums.get(i).get(j));

                // 记录最大的对角线索引
                maxKey = Math.max(maxKey, key);
            }
        }

        List<Integer> result = new ArrayList<>();
        // 按照对角线顺序遍历并取出元素
        for (int key = 0; key <= maxKey; key++) {
            if (diagonalMap.containsKey(key)) {
                // 这里需要逆序加入对角线上的元素
                List<Integer> diagonalElements = diagonalMap.get(key);
                for (int i = diagonalElements.size() - 1; i >= 0; i--) {
                    result.add(diagonalElements.get(i));
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}