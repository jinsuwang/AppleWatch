package com.samjin.math;

public class ReverseInteger {

    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int digit = x % 10;
            int temp = res * 10 + digit;

            if(temp / 10 != res){
                return 0;
            }

            res = temp;
            x /= 10;
        }

        return res;
    }
}
