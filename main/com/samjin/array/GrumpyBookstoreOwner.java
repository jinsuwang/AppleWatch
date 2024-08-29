package com.samjin.array;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0; // 基础满意度
        int maxIncrease = 0; // 最大化潜在收益
        int increase = 0; // 当前窗口内的潜在收益

        for (int i = 0; i < customers.length; i++) {
            // 计算基础满意度：老板心情好时，直接加上顾客数
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                // 计算潜在收益：老板心情不好时，记录该时间段内的顾客数
                increase += customers[i];
            }

            // 如果窗口已经滑动到超过X的范围，减去最左边的潜在收益
            if (i >= minutes) {
                increase -= customers[i - minutes] * grumpy[i - minutes];
            }

            // 更新最大化潜在收益
            maxIncrease = Math.max(maxIncrease, increase);
        }

        // 返回基础满意度加上最大化的潜在收益
        return satisfied + maxIncrease;
    }
}
