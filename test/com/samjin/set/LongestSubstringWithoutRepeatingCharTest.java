package com.samjin.set;

import com.samjin.hashmap.LongestSubstringWithoutRepeatingChar;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sjjin on 9/5/17.
 */
public class LongestSubstringWithoutRepeatingCharTest {

    @Test
    public void run() throws Exception {

        LongestSubstringWithoutRepeatingChar instance = new LongestSubstringWithoutRepeatingChar();

        String input1 = "abcabcbb";
        int expect1 = 3;
        Assert.assertEquals(instance.run(input1),expect1);


        String input2 = "bbbbb";
        int expect2 = 1;
        Assert.assertEquals(instance.run(input2),expect2);


        String input3 = "pwwkew";
        int expect3 = 3;
        Assert.assertEquals(instance.run(input3),expect3);

    }

}