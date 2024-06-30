package com.samjin.tree;

import com.samjin.util.TestFactory;
import org.junit.Before;
import org.junit.Test;

public class BSTIteratorTest {

    BSTIterator ins;

    @Before
    public void setUp(){
        TreeNode root = TestFactory.getTestIntegerBST();
        ins = new BSTIterator(root);
    }

    @Test
    public void test() {
        while(ins.hasNext()){
            System.out.println(ins.next());
        }
    }
}