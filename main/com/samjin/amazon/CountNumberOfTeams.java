package com.samjin.amazon;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int l = 0;
            int r = 0;
            for (int i = 0; i < j; ++i)
                if (rating[i] < rating[j]) ++l;
            for (int k = j + 1; k < n; ++k)
                if (rating[j] < rating[k]) ++r;
            ans += (l * r) + (j - l) * (n - j - 1 - r);
        }
        return ans;

    }
}
