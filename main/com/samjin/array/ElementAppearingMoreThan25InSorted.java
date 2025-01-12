package com.samjin.array;

public class ElementAppearingMoreThan25InSorted {

    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;

        for (int i = 0; i < n - threshold; i++) {
            // 检查当前位置和 threshold 距离后的元素是否相等
            if (arr[i] == arr[i + threshold]) {
                return arr[i];
            }
        }

        return -1; // 题目保证一定存在满足条件的元素，因此不会到达这里
    }
}
