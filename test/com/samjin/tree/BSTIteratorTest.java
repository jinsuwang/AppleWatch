package com.samjin.tree;

import com.samjin.util.TestFactory;
import com.samjin.util.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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