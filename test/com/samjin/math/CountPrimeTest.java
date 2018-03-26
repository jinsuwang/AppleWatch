package com.samjin.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimeTest {

    CountPrime ins = new CountPrime();

    @Test
    public void countPrimes() {
        System.out.println(ins.countPrimes(5));
    }
}