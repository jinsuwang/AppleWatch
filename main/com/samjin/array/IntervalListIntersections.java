package com.samjin.array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int len1 = A.length;
        int len2 = B.length;
        List<int[]> list = new ArrayList<>();

        int i = 0 ;
        int j = 0 ;
        while(i<len1&&j<len2){
            int s1 = A[i][0];
            int e1 = A[i][1];
            int s2 = B[j][0];
            int e2 = B[j][1];

            if(s2>e1)i++;
            else if(e2<s1)j++;
            else {               //intersect
                int[] a = new int[2];
                a[0]= Math.max(s1,s2);
                a[1]= Math.min(e1,e2);
                list.add(a);
                if(e1>e2)j++;
                if(e2>=e1)i++;
            }
        }
        int n = list.size();
        int[][] ans = list.toArray(new int[n][2]);
        return ans;
    }
}
