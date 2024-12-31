package com.samjin.segmenttree;

public class RangeSumQueryImmutable {

    private int[] prefixSum;

    public RangeSumQueryImmutable(int[] nums) {

        // 初始化前缀和数组
        prefixSum = new int[nums.length + 1];
        // prefixSum[i] 表示从 nums[0] 到 nums[i-1] 的和
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
