package com.samjin.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctSubsequencesTest {

    @Test
    public void numDistinct() {
        DistinctSubsequences ins = new DistinctSubsequences();
        ins.numDistinct("babgbag", "bag");
    }
}