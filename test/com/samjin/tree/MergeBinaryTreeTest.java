package com.samjin.tree;

import com.samjin.util.MyPrinter;
import com.samjin.util.TestFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sjjin on 12/11/17.
 */
public class MergeBinaryTreeTest {

    MergeBinaryTree instance;

    @Before
    public void setUp(){
        instance = new MergeBinaryTree();
    }

    @Test
    public void mergeTrees() throws Exception {

        TreeNode t1 = TestFactory.getTestIntegerBST();
        TreeNode t2 = TestFactory.getTestIntegerBST();

        TreeNode actual = instance.mergeTrees(t1,t2);

        MyPrinter.printTreeLevelOrder(actual);


    }

}