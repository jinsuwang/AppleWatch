package com.samjin.bit;

public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int res = 0;
        while(!(x == 0 && y == 0)){
//            System.out.println("x & 1 = " + (x&1));
//            System.out.println("y & 1 = " + (y&1));
            if((x & 1) != (y & 1)) res++;
            x = x >> 1;
            y = y >> 1;
//            System.out.println("x: " + x + " y: " + y);
        }
        return res;
    }
}
