package com.samjin.array;

import java.util.Random;

public class RandomPickIndex {

    private int[] nums;
    private Random rand;

    public RandomPickIndex(int[] nums) {

        this.nums = nums;
        this.rand = new Random();

    }

    public int pick(int target) {
        int count = 0; // 用于记录target出现的次数
        int result = -1; // 用于记录结果索引

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // 使用水塘抽样算法，以 1/count 的概率更新结果索引
                if (rand.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}
