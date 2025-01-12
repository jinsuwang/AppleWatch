package com.samjin.array;

public class CuttingRibbons {

    public int maxLength(int[] ribbons, int k) {
        int left = 1, right = 0;

        // 找到最大长度
        for (int ribbon : ribbons) {
            right = Math.max(right, ribbon);
        }

        int result = 0;

        // 二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 检查是否可以剪出至少 k 段
            if (canCut(ribbons, mid, k)) {
                result = mid; // 记录当前长度为可能的解
                left = mid + 1; // 尝试更长的段
            } else {
                right = mid - 1; // 减小段长度
            }
        }

        return result;
    }

    // 验证函数：判断是否能剪出至少 k 段长度为 mid 的彩带
    private boolean canCut(int[] ribbons, int mid, int k) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += ribbon / mid; // 当前彩带能剪出的段数
        }
        return count >= k;
    }
}
