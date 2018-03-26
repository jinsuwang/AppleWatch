package com.samjin.math;

public class Sqrt {

    public int mySqrt(int x) {

        if(x == 1 || x == 0) return x;

        int left = 1;
        int right = x;

        while(left < right -1) {
            int mid = left + (right - left) / 2;
            int candidate = x / mid;

            if(candidate == mid) return  candidate; // we find it.
            else if( candidate < mid){ // we divided a large number.
                right = mid;
            }else if( candidate > mid){
                left = mid;
            }
        }
        return left;
    }
}
