package com.samjin.tree;

import com.samjin.util.TestFactory;
import com.samjin.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTest {

    BinaryTreeRightSideView ins = new BinaryTreeRightSideView();

    @Test
    public void rightSideView() {
        TreeNode node = TestFactory.getTestIntegerBST();
        System.out.println(ins.rightSideView(node));
    }
}