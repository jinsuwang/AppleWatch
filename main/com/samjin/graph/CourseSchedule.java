package com.samjin.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int res = numCourses;

        // 找入度为0，表示可以开始学习的课
        for(int[] pair : prerequisites){
            // [1,0] => 0->1
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 入度为0的加入，然后bfs
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                // 当前这个课已经可以学了
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int[] pair : prerequisites){
                // 如果这门课已经可以学习了，就不加入queue
                if(indegree[pair[0]] == 0){
                    continue;
                }

                if(pair[1] == curr){
                    indegree[pair[0]]--;
                }
                // 这门课原来不能学习，现在可以学习了
                if(indegree[pair[0]] == 0){
                    queue.offer(pair[0]);
                }
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] != 0){
                return false;
            }
        }

        return true;
    }
}