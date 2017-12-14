package com.samjin.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 12/13/17.
 */
public class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring instance;

    @Before
    public void setUp() throws Exception {
        instance = new LongestPalindromicSubstring();
    }

    @Test
    public void longestPalindrome() throws Exception {

        String input1 = "babad", expected1 = "bab";
        String input2 = "cbbd", expected2 = "bb";

        Assert.assertEquals(expected1, instance.longestPalindrome(input1));
        Assert.assertEquals(expected2, instance.longestPalindrome(input2));

    }

}