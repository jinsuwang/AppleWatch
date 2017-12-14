package com.samjin.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 12/11/17.
 */
public class MyPrinterTest {

    @Test
    public void printTreeLevelOrder() throws Exception {
        TreeNode t1 = TestFactory.getTestIntegerBST();
        MyPrinter.printTreeLevelOrder(t1);
    }

}