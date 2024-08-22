package com.samjin.string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {


    public String largestNumber(int[] nums) {
        // 将整数组转换为字符串数组
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 自定义排序规则
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // 降序排列
            }
        });

        // 如果排序后最大的数字是 "0"，直接返回 "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 将排序后的字符串数组拼接成一个字符串
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}
