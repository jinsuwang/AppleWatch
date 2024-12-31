package com.samjin.sortandsearch;

import java.util.Arrays;

public class FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {
        // 先对年龄数组进行排序
        Arrays.sort(ages);
        int totalRequests = 0;

        // 使用双指针法统计好友请求
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];

            // 如果年龄小于 15 则不能发送好友请求（根据题目的条件）
            if (age < 15) continue;

            // 找到满足 0.5 * age + 7 < y 的最小索引
            int left = binarySearchLeft(ages, 0.5 * age + 7);
            // 找到满足 y <= age 的最右索引
            int right = binarySearchRight(ages, age);

            // 计算合法的好友请求数（减去自己）
            totalRequests += right - left - 1;
        }

        return totalRequests;
    }

    // 查找满足条件的最左边的索引
    private int binarySearchLeft(int[] ages, double minAge) {
        int left = 0, right = ages.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] <= minAge) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 查找满足条件的最右边的索引
    private int binarySearchRight(int[] ages, int maxAge) {
        int left = 0, right = ages.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] <= maxAge) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
