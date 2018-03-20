package com.samjin.tree;

import com.samjin.util.TestFactory;
import com.samjin.util.TreeNode;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {

    ValidateBinarySearchTree ins = new ValidateBinarySearchTree();

    @Test
    public void test(){
        TreeNode tree = TestFactory.getTestIntegerBST();
        System.out.println(ins.isValidBST(tree));
    }
}