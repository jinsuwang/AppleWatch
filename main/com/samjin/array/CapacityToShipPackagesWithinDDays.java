package com.samjin.array;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        // 确定二分查找范围
        for (int weight : weights) {
            left = Math.max(left, weight); // 最小运载能力为最大重量
            right += weight; // 最大运载能力为总重量
        }

        // 二分查找最小运载能力
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid; // 尝试更小的运载能力
            } else {
                left = mid + 1; // 增大运载能力
            }
        }

        return left; // left == right 时即为答案
    }

    // 辅助函数：判断在给定运载能力下，能否在规定天数内完成运输
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                // 超过当前运载能力，增加一天
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += weight;

            // 如果需要的天数超过限制，直接返回 false
            if (requiredDays > days) {
                return false;
            }
        }

        return true;
    }
}
