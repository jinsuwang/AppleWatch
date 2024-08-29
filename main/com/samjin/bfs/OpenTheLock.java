package com.samjin.bfs;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        if (deadSet.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++){
                String current = queue.poll();
                if (current.equals(target)) return steps;
                for (String next : getNextStates(current)) {
                    // 如果状态没被访问过，且不是死锁状态，加入队列
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private List<String> getNextStates(String state) {

        List<String> nextStates = new ArrayList<>();
        char[] chars = state.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // 向上转动一位
            chars[i] = original == '9' ? '0' : (char) (original + 1);
            nextStates.add(new String(chars));

            // 向下转动一位
            chars[i] = original == '0' ? '9' : (char) (original - 1);
            nextStates.add(new String(chars));

            // 恢复原状
            chars[i] = original;
        }

        return nextStates;

    }
}
