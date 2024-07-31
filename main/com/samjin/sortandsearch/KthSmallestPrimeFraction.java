package com.samjin.sortandsearch;

public class KthSmallestPrimeFraction {


    // Hard.
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        final int n = A.length;
        double l = 0;
        double r = 1.0;
        while (l < r) {
            double m = (l + r) / 2;
            double max_f = 0.0;
            int total = 0;
            int p = 0;
            int q = 0;
            for (int i = 0, j = 1; i < n - 1; ++i) {
                while (j < n && A[i] > m * A[j]) ++j;
                if (n == j) break;
                total += (n - j);
                final double f = (double)A[i] / A[j];
                if (f > max_f) {
                    p = i;
                    q = j;
                    max_f = f;
                }
            }
            if (total == K)
                return new int[]{A[p], A[q]};
            else if (total > K)
                r = m;
            else
                l = m;
        }
        return new int[] {};
    }
}