package com.samjin.sortandsearch;

public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // 统计有多少个数小于等于 mid
            int count = countLessEqual(matrix, mid, n);

            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private int countLessEqual(int[][] matrix, int mid, int n) {
        int count = 0;
        int row = n - 1;
        int col = 0;

        // 从矩阵的左下角开始统计
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                // 该列的所有元素都小于等于 mid
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}
