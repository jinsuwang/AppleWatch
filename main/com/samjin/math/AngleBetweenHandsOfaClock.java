package com.samjin.math;

public class AngleBetweenHandsOfaClock {

    public double angleClock(int hour, int minutes) {
        // 将小时限制在 12 小时制内
        hour = hour % 12;

        // 计算时针的角度
        double hourAngle = hour * 30 + minutes * 0.5;

        // 计算分针的角度
        double minuteAngle = minutes * 6;

        // 计算两者的夹角
        double angle = Math.abs(hourAngle - minuteAngle);

        // 取最小角度
        return Math.min(angle, 360 - angle);
    }
}
