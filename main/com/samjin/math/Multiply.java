package com.samjin.math;

public class Multiply {

    public static int multiply(int a, int b) {
        // Base case: multiplication by 0 results in 0
        if (b == 0) {
            return 0;
        }

        // If b is negative, convert the problem to its positive equivalent
        if (b < 0) {
            return -multiply(a, -b);
        }

        // If b is even, use the property: a * b = 2 * (a * (b / 2))
        if (b % 2 == 0) {
            int halfProduct = multiply(a, b / 2);
            return halfProduct + halfProduct;
        } else {
            // If b is odd, use the property: a * b = a + a * (b - 1)
            return a + multiply(a, b - 1);
        }
    }
}
