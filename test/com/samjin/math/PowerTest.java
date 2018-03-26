package com.samjin.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    Power ins = new Power();

    @Test
    public void myPow() {
        System.out.println(ins.myPow(2,-3));
    }
}