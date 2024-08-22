package com.samjin.math;

public class ReverseInteger {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; // 取 x 的最后一位数字
            x /= 10; // 去掉最后一位数字

            // 检查是否会溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            rev = rev * 10 + pop; // 将数字添加到 rev
        }
        return rev;
    }
}
