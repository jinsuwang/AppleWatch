package com.samjin.string;

public class MaximumSwap {

    public int maximumSwap(int num) {
        int[] dict = new int[10];
        char[] arr = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            // 这个数字的最后一个index
            dict[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            int currNum = arr[i] - '0';
            // 比当前数大的数
            // 并且在当前数后边
            for (int k = 9; k > currNum; k--) {
                // index在当前数字之后
                if (dict[k] > i) {
                    char temp = arr[i];
                    arr[i] = arr[dict[k]];
                    arr[dict[k]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }

        return num;
    }
}
