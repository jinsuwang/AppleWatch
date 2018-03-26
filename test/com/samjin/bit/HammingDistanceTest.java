package com.samjin.bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class HammingDistanceTest {

    HammingDistance ins = new HammingDistance();

    @Test
    public void hammingDistance() {
        System.out.println(ins.hammingDistance(1,4));
    }
}