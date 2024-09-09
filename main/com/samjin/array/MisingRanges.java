package com.samjin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MisingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        // 初始化prev为lower - 1, 方便处理与lower边界相连的情况
        int prev = lower - 1;

        // 遍历数组的每一个元素，最后处理upper + 1作为结尾边界
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;

            // 如果当前数比前一个数多两个及以上，说明中间有缺失的区间
            if (prev + 1 <= curr - 1)
                result.add(Arrays.asList(prev + 1, curr - 1));

            // 更新prev为当前数
            prev = curr;
        }

        return result;
    }

}
