package com.samjin.stackandqueue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sjjin on 12/13/17.
 */
public class ValidParenthesesTest {

    ValidParentheses ins;

    @Before
    public void setUp() throws Exception {
        ins = new ValidParentheses();
    }

    @Test
    public void isValid() throws Exception {

        String input1 = "()[]{}";

        Assert.assertEquals( ins.isValid(input1), true);
    }

}