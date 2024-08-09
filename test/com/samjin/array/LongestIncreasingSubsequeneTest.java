package com.samjin.array;

import com.samjin.dp.LongestIncreasingSubsequene;
import org.junit.Test;

public class LongestIncreasingSubsequeneTest {


    LongestIncreasingSubsequene ins = new LongestIncreasingSubsequene();
    @Test
    public void lengthOfLIS() {
        int[] test = new int[]{10,9,2,5,3,7,101,18};

        int res = ins.lengthOfLIS(test);

        System.out.println(res);


    }
}