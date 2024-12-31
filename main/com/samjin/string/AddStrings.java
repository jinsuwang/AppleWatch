package com.samjin.string;

public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;  // 记录进位

        // 从两个字符串的末尾开始相加
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;  // 获取num1的当前位，没有则为0
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;  // 获取num2的当前位，没有则为0

            int sum = n1 + n2 + carry;  // 当前位的和加上进位
            result.append(sum % 10);  // 当前位的结果放入结果中
            carry = sum / 10;  // 更新进位

            i--;  // 移动到下一个数字
            j--;  // 移动到下一个数字
        }

        return result.reverse().toString();  // 因为我们是从低位开始加的，所以最后需要反转字符串
    }
}
