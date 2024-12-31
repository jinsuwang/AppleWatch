package com.samjin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfTwoRunLengthEncodedArrays {

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < encoded1.length && j < encoded2.length) {
            int value1 = encoded1[i][0];
            int freq1 = encoded1[i][1];
            int value2 = encoded2[j][0];
            int freq2 = encoded2[j][1];

            // 计算乘积
            int productValue = value1 * value2;
            int productFreq = Math.min(freq1, freq2); // 取较小的频率作为这个乘积的频率

            // 如果乘积和上一个值一样，合并频率
            if (!result.isEmpty() && result.get(result.size() - 1).get(0) == productValue) {
                int prevFreq = result.get(result.size() - 1).get(1);
                result.get(result.size() - 1).set(1, prevFreq + productFreq);
            } else {
                // 否则，添加新的 [value, frequency] 对
                result.add(Arrays.asList(productValue, productFreq));
            }

            // 更新两个数组的频率
            if (freq1 == productFreq) {
                i++;
            } else {
                encoded1[i][1] -= productFreq;
            }

            if (freq2 == productFreq) {
                j++;
            } else {
                encoded2[j][1] -= productFreq;
            }
        }

        return result;
    }


}
