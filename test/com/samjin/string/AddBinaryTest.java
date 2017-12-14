package com.samjin.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 9/11/17.
 */
public class AddBinaryTest {
    @Test
    public void addBinary() throws Exception {

        AddBinary instance = new AddBinary();

        String res = instance.addBinary("11", "1");

        System.out.println(res);
    }

}