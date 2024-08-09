package com.samjin.bfs;

import java.util.*;

public class SlidingPuzzle {

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = toString(board);

        // 如果初始状态即为目标状态
        if (start.equals(target)) {
            return 0;
        }

        // 使用队列进行BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        // 记录已经访问过的状态
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getNextStates(current)) {
                    if (!visited.contains(next)) {
                        // 如果找到目标状态
                        if (next.equals(target)) {
                            return step + 1;
                        }
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }

        return -1; // 如果不能解决，返回-1
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] array = current.toCharArray();
        int zeroIndex = current.indexOf('0');
        int zeroX = zeroIndex / 3;
        int zeroY = zeroIndex % 3;

        // 尝试移动0到四个方向
        for (int[] dir : DIRS) {
            int newX = zeroX + dir[0];
            int newY = zeroY + dir[1];
            if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                int newIndex = newX * 3 + newY;
                swap(array, zeroIndex, newIndex);
                nextStates.add(new String(array));
                swap(array, zeroIndex, newIndex); // 复原
            }
        }

        return nextStates;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private String toString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
