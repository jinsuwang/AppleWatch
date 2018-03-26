package com.samjin.math;

public class Power {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n < 0){
            double ret = x * myPow(x, -(n+1) );
            return 1/ret;
        }
        double ret = myPow(x, n/2);
        ret = ret * ret;

        if(n % 2 == 1){
            ret = ret * x;
        }
        return ret;
    }
}
