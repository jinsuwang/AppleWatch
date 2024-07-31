package com.samjin.sortandsearch;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        // 减少操作次数
        if (len1 > len2) {
            // 确保N1是短的部分
            return findMedianSortedArrays(nums2, nums1);
        }

        // 开始从nums1中取元素
        int left = 0;
        int right = len1;

        while (left <= right) {
            // 从nums1和nums2中分别取m1和m2个元素组成k个元素
            int m1 = left + (right - left) / 2;
            int m2 = (len1 + len2) / 2 - m1;

            // k -> max(L1, L2), (k + 1) -> min(R1, R2)
            // nums1没有取元素?
            // 此时左边的元素一定从nums2中取，因此要使得L1 = MIN_VALUE
            // 这样max(L1, L2)就会取到L2了
            // 这时所取得元素中num2的元素都要比nums1中的小
            // 因此在min(R1,R2)的时候，选中的也是R2
            double m1Left = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
            // nums1取了所有的元素?
            double m1Right = (m1 == len1) ? Integer.MAX_VALUE : nums1[m1];

            // nums2没有取元素?
            double m2Left = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
            // nums2取了所有的元素?
            double m2Right = (m2 == len2) ? Integer.MAX_VALUE : nums2[m2];

            // 左边取多了
            if (m1Left > m2Right) {
                right = m1 - 1;
            }else if (m2Left > m1Right) {
                // 左边取少了
                left = m1 + 1;
            } else {
                // 此时是符合要求的排列情况
                if ((len1 + len2) % 2 == 0){
                    double medLeft = Math.max(m1Left, m2Left);
                    double medRight = Math.min(m1Right, m2Right);
                    return (medLeft + medRight) / 2.0;
                } else {
                    return Math.min(m1Right, m2Right);
                }
            }
        }

        return -1;

    }
}
