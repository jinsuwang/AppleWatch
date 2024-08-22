package com.samjin.dp;

public class NumberOfGoodLeafNodesPairs {

    public int minimumDeletions(String s) {
        int n = s.length();
        int[] leftB = new int[n + 1];  // 记录从0到i的b的数量
        int[] rightA = new int[n + 1]; // 记录从i到n的a的数量

        // 计算左边的 b 的数量
        for (int i = 0; i < n; i++) {
            leftB[i + 1] = leftB[i] + (s.charAt(i) == 'b' ? 1 : 0);
        }

        // 计算右边的 a 的数量
        for (int i = n - 1; i >= 0; i--) {
            rightA[i] = rightA[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            // 计算每一个切分点的最小删除次数
            minDeletions = Math.min(minDeletions, leftB[i] + rightA[i]);
        }

        return minDeletions;
    }
}
