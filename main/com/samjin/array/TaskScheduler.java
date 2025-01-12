package com.samjin.array;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for (char task : tasks) {
            dict[task - 'A']++;
        }

        int maxCount = 0;
        int maxCountSame = 0;

        for (int num : dict) {
            if(num > maxCount) {
                maxCount = num;
                maxCountSame = 1;
            } else if (num == maxCount) {
                maxCountSame++;
            }
        }

        int res = (maxCount - 1) * (n + 1) + maxCountSame;
        return Math.max(res, tasks.length);
    }
}
