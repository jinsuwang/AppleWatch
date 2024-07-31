package com.samjin.bfs;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        HashSet<String> set = new HashSet<>();

        Collections.addAll(set, bank);

        if (!set.contains(end)) return -1;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        char[] choices = {'A', 'C', 'G', 'T'};

        queue.offer(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++){
                String curr = queue.poll();

                for(int m = 0; m < 8; m++){
                    StringBuilder sb = new StringBuilder(curr);

                    for(char c : choices){
                        sb.setCharAt(m, c);
                        String next = sb.toString();

                        if(next.equals(end)){
                            return step + 1;
                        }

                        if(set.contains(next) && !visited.contains(next)){
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }

            step++;
        }

        return -1;
    }
}
