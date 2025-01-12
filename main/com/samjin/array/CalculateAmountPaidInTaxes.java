package com.samjin.array;

public class CalculateAmountPaidInTaxes {

    public double calculateTax(int[][] brackets, int income) {
        double tax = 0.0;
        int previousUpper = 0; // 上一个区间的上限

        for (int[] bracket : brackets) {
            int upper = bracket[0]; // 当前区间的上限
            int percent = bracket[1]; // 当前区间的税率

            // 计算当前区间应税部分
            int taxableIncome = Math.min(income, upper) - previousUpper;
            if (taxableIncome > 0) {
                tax += taxableIncome * percent / 100.0; // 累加税额
            }

            // 更新上一税率区间的上限
            previousUpper = upper;

            // 如果收入已经小于或等于当前区间的上限，停止计算
            if (income <= upper) {
                break;
            }
        }

        return tax;
    }
}
